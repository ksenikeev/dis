package ru.itis.dis.arbiter.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itis.dis.arbiter.bc.BlockChain;
import ru.itis.dis.arbiter.bc.BlockModel;
import ru.itis.dis.arbiter.bc.NewBlockResponse;
import ru.itis.dis.arbiter.service.SignService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class BlockChainRestController {

    private static Logger log = Logger.getLogger(BlockChainRestController.class.getName());

    @Autowired
    private SignService signService;

    @ResponseBody
    @GetMapping(value = "/dis/newblock")
    /*  http://localhost:8090/dis/newblock?block={...}    URLEncoded */
    public NewBlockResponse newBlockGetHandler(@RequestParam(name = "block") String blockStr) {

        log.info("new block: " + blockStr);

        Date ts = new Date();

        // Парсим присланные данные
        ObjectMapper mapper = new ObjectMapper();
        BlockModel block = null;
        try {
            block = mapper.readValue(blockStr, BlockModel.class);
        } catch (JsonProcessingException e) {
            log.log(Level.SEVERE,"error",e);
            return new NewBlockResponse(2,"mapper error: " + e.getMessage(),null);
        }

        //Вычиляем хеш нашего последнего блока и сравниваем с присланным prevHash
        // должны совпадать
        int sz = BlockChain.chain.size();
        try {
            // расчет хеша предыдущего блока
            String prevHash = sz > 0 ? new String(Hex.encode(signService.getHash(BlockChain.chain.get(sz - 1)))) : null;

            if (!block.getPrevhash().equals(prevHash)) {
                log.info("Hash error. Last block has hash: " + prevHash );
                return new NewBlockResponse(2, "Hash error. Last block has hash: " + prevHash, null);
            }

        } catch (Exception e) {
            log.log(Level.SEVERE,"error",e);
            return new NewBlockResponse(2, "server error: " + e.getMessage(), null);
        }

        block.setTs( new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SX").format(ts));

        BlockChain.chain.add(block);
        BlockChain.saveBlockChain();
        log.info("block " + block.getData().getName() + " added ");
        NewBlockResponse resp =  new NewBlockResponse(0,"",block);

        return resp;
    }

    /**
     * Запрос цепочки блоков начиная с блока, следующего за тем, хеш которого совпадает с
     * параметром запроса
     * @param prevHash
     * @return
     *
     *  http://localhost:8090/dis/chain
     *  http://localhost:8090/dis/chain?hash=334523452345....
     */
    @ResponseBody
    @GetMapping(value = "/dis/chain")
    public List<BlockModel> newBlockPostHandler(@RequestParam(name = "hash", required = false) String prevHash) {

        List<BlockModel> lst = new ArrayList<>();

        if (prevHash == null) {
            return BlockChain.chain;
        }

        int i = 0;
        for (; i < BlockChain.chain.size(); i++) {
            if (prevHash.equals(BlockChain.chain.get(i).getPrevhash())) break;
        }

        for (; i < BlockChain.chain.size(); i++) {
            lst.add(BlockChain.chain.get(i));
        }

        return lst;
    }

}
