import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;

public class Principal {
    public static BufferedImage imagemPretoBranco(BufferedImage imagem) throws IOException {
        int w = imagem.getHeight();
        int h = imagem.getWidth();
        byte[] comp = {0, -1};

        IndexColorModel cm = new IndexColorModel(2,2,comp, comp, comp);

        BufferedImage novaImagem = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_INDEXED, cm);
        Graphics2D g = novaImagem.createGraphics();
        g.drawRenderedImage(imagem, null);
        g.dispose();

        String temp = "pretoBranco.png";
        File fi = new File(temp);
        ImageIO.write(novaImagem, "png", fi);
        return novaImagem;

    }
    public static BufferedImage carregarImagem(){
        try {
            BufferedImage a = ImageIO.read(new File("a1.png"));
            return a;
        }catch (IOException e){
            System.out.println("Erro: "+e.getMessage());
            return null;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedImage a;
        a = carregarImagem();
        a = imagemPretoBranco(a);
        int thershold = 200;
        int cont = 0;
        boolean matrizIa[][] = new boolean[5][8];
        double ap = a.getWidth()/5;
        double lp = a.getHeight()/8;

        for(int i=0; i<5; i++){
            for(int j=0; j<8; j++){
                
            }
        }


        boolean matrizBinaria[][] = new boolean[a.getWidth()][a.getHeight()];

        for(int y=0; y<a.getHeight(); y++){
            for(int x=0; x<a.getWidth(); ++x){
                matrizBinaria[x][y] = new Color(a.getRGB(x,y)).getRed() >=thershold;
                if(matrizBinaria[x][y] == true){
                    System.out.println("Matriz: 0");
                    cont++;
                }else {
                    System.out.println("Matriz: 1");
                    cont++;
                }
            }
        }

        System.out.println("Total de Entradas: "+cont);
    }
}
