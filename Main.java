
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Main extends Application {

	@Override
	public void start(Stage palco){

		// Etiquetas para os campos de entrada

		Label etiquetaPeso = new Label("Peso");
		etiquetaPeso.getStyleClass().add("etiqueta");
		Label etiquetaAltura = new Label("Altura");
		etiquetaAltura.getStyleClass().add("etiqueta");

		// Campos de entrada

		TextField campoPeso = new TextField();
		campoPeso.setPromptText("Peso em kg");
		campoPeso.getStyleClass().add("caixaTexto");

		TextField campoAltura = new TextField();
		campoAltura.setPromptText("Altura em metro");
		campoAltura.getStyleClass().add("caixaTexto");

		// Label para mostrar o resultado do imc

		Label etiquetaResultado = new Label();
		etiquetaResultado.getStyleClass().add("etiqueta");

		// Botão para calcular o IMC

		Button botaoCalcular = new Button("Calcular IMC");
		botaoCalcular.getStyleClass().add("botaoCalcular");
		botaoCalcular.setOnAction(e -> {
			try {
			double peso = Double.parseDouble(campoPeso.getText().replace(",","."));
			double altura = Double.parseDouble(campoAltura.getText().replace(",","."));

			double imc = peso/altura/altura;

			if ( imc <18.5 && imc > 0){
				etiquetaResultado.setText(String.format("Seu IMC é: %.1f. Está abaixo do peso ideal",imc));
			}

			else if ( imc >= 18.5 && imc < 25){
				etiquetaResultado.setText(String.format("Seu IMC é: %.1f. Está no peso ideal",imc));
			}

			else if (imc >=25 && imc <30){
				etiquetaResultado.setText(String.format("Seu IMC é: %.1f. Excesso de peso",imc));
			}

			else if (imc >=30 && imc <35){
				etiquetaResultado.setText(String.format("Seu IMC é: %.1f. Obesidade Classe 1",imc));
			}

			else if (imc >=35 && imc <40){
				etiquetaResultado.setText(String.format("Seu IMC é: %.1f. Obesidade Classe 2",imc));
			}

			else if (imc >= 40 && imc < 60){
				etiquetaResultado.setText(String.format("Seu IMC é: %.1f. Obesidade Classe 3",imc));
			}
			else {
				etiquetaResultado.setText("Verifique se colocou os números corretamente. Ninguém é tão gordo assim");
			}


			
			} catch (NumberFormatException ex){
				etiquetaResultado.setText("Insira números nos campos");
			}
			
		});



		// Layout Vertical
		VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular,etiquetaResultado);
		layout.setPadding(new Insets(10));
		layout.setAlignment(Pos.CENTER);
		layout.getStyleClass().add("layout");

		// Cena e Palco

		Scene cena = new Scene(layout, 400, 250);
		cena.getStylesheets().add("./styles.css");
		palco.setTitle("Calculadora de IMC");
		palco.setScene(cena);
		palco.show();

	}

	public static void main(String[]args){
		launch(args);
	}
}

/* Melhorias para fazer:

Adicionar estilo com CSS. Fazer em outro arquivo para treinar

	*/

