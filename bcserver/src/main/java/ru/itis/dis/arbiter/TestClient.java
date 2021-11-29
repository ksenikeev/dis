package ru.itis.dis.arbiter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import ru.itis.dis.arbiter.bc.BlockChain;
import ru.itis.dis.arbiter.bc.BlockModel;
import ru.itis.dis.arbiter.bc.DataModel;
import ru.itis.dis.arbiter.bc.NewBlockResponse;
import ru.itis.dis.arbiter.service.SignService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class TestClient {

    public static void main(String[] args) throws Exception {

        SignService signService = new SignService();
        // get all blocks

        BlockModel[] bloks = getBlockChain();

        String prevHash = new String(Hex.encode(signService.getHash(bloks[bloks.length - 1])));

        BlockModel blockModel = new BlockModel();

        blockModel.setPrevhash(prevHash);

        DataModel dataModel = new DataModel("4 block data","Enikeev Kamil");
        blockModel.setData(dataModel);
        String signature = new String(Hex.encode(signService.generateRSAPSSSignature(dataModel.toString().getBytes())));
        blockModel.setSignature(signature);
        blockModel.setPublickey(SignService.publicKey16);

        sendBlock(blockModel);
    }

     // Отправка блока
    public static void sendBlock(BlockModel blockModel) {
        try {
            URL url = new URL("http://188.93.211.195/dis/newblock?block=" +
                    URLEncoder.encode(blockModel.toString(),"UTF-8"));

            System.out.println(url);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            int rcode = con.getResponseCode();

            if (rcode == 200) {

                ObjectMapper mapper = new ObjectMapper();
                NewBlockResponse blockResponce =
                mapper.readValue(con.getInputStream(), NewBlockResponse.class);

                System.out.println(blockResponce);
            } else {
                System.out.println("response code = " + rcode);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Отправка блока
    public static BlockModel[] getBlockChain() {
        try {
            URL url = new URL("http://188.93.211.195/dis/chain");

            System.out.println(url);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            int rcode = con.getResponseCode();

            if (rcode == 200) {

                ObjectMapper mapper = new ObjectMapper();
                BlockModel[] blocks =
                        mapper.readValue(con.getInputStream(), BlockModel[].class);
                System.out.println(blocks.length);
                return blocks;
            } else {
                System.out.println("response code = " + rcode);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    public static boolean verify(String publicKeyHexStr, byte[] data, String signHexStr) {
        Security.addProvider(new BouncyCastleProvider());

        try {
            Signature signature = Signature.getInstance(SIGN_ALGORITHM, "BC");

            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(Hex.decode(publicKeyHexStr));
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
            signature.initVerify(pubKey);

            signature.update(data);

            return signature.verify(Hex.decode(signHexStr));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

*/

}
