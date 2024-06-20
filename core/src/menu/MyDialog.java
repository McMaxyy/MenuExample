package menu;

import java.io.FileNotFoundException;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import config.Storage;

public class MyDialog extends Dialog {

    private TextArea text;
    private TextButton confirmButton;
    private Random rand = new Random();
    private Storage storage;

    public MyDialog(String title, Skin skin, Stage stage) {
        super(title, skin);
        Gdx.input.setInputProcessor(stage);
        storage = Storage.getInstance();
        storage.createFont();
        skin = storage.skin;
        text = new TextArea("", storage.textStyle);
        confirmButton = new TextButton("Oddaj narocilo", skin);

        // Add components to the dialog
        getContentTable().add("Pritisni ESC ce zelis nadeljevati z izbiro jedi").colspan(2).padBottom(10).row();
        getContentTable().add(text).width(300).height(300).padBottom(10).row();
        button(confirmButton).setHeight(100);

        confirmButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Home.komentar = text.getText();
                createPDF();
                hide();
                Gdx.app.exit();
                System.exit(-1);
            }
        });

        setSize(450, 350);
        setPosition(stage.getWidth() / 2 - getWidth() / 2, stage.getHeight() / 2 - getHeight() / 2);
    }
    
    private void createPDF() {
    	String userHomeDir = System.getProperty("user.home");
        String dest = userHomeDir + "/Desktop/Narocilo" + rand.nextInt(1001) + ".pdf";
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            
            document.add(new Paragraph("Predjed: " + Home.izbiraPredjed));
            document.add(new Paragraph("Glavna jed: " + Home.izbiraGlavna));
            document.add(new Paragraph("Priloga: " + Home.izbiraPriloga));
            document.add(new Paragraph("Solata: " + Home.izbiraSolata));
            document.add(new Paragraph("Pijaca: " + Home.izbiraPijaca));
            document.add(new Paragraph("Sladica: " + Home.izbiraSladica));
            document.add(new Paragraph("Komentar: " + Home.komentar));

            document.close();
            System.out.println("PDF created successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
