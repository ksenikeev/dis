package ru.itis.dis.arbiter.config;

import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.itis.dis.arbiter.bc.BlockChain;
import ru.itis.dis.arbiter.bc.BlockModel;
import ru.itis.dis.arbiter.bc.DataModel;
import ru.itis.dis.arbiter.service.SignService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


/**
 * Обработка события - старта приложения
 * Формируем нулевой блок
 */
@Component
public class BlocChainApplicationnListener implements ApplicationListener<ApplicationStartedEvent> {

    private static Logger log = Logger.getLogger(BlocChainApplicationnListener.class.getName());

    @Autowired
    private SignService signService;

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event)  {

        log.info("start application");

        BlockChain.readBlockChain();

        if (BlockChain.chain.size() == 0) {

            log.info("blockchain size = 0");

            DataModel dm = new DataModel("first block data","");
            BlockModel block = new BlockModel();
            block.setData(dm);

            try {
                String signature = new String(Hex.encode(signService.generateRSAPSSSignature(dm.toString().getBytes())));
                block.setSignature(signature);

                block.setTs(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SX").format(new Date()));

                block.setPublickey(SignService.publicKey16);
            } catch (Exception e) {
                e.printStackTrace();
            }
            BlockChain.chain.add(block);

            BlockChain.saveBlockChain();
        }

    }
}
