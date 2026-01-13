
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
		Label etiquetaAltura = new Label("Altura");

		// Campos de entrada

		TextField campoPeso = new TextField();
		campoPeso.setPromptText("Peso em kg");
		TextField campoAltura = new TextField();
		campoAltura.setPromptText("Altura em metro");

		// Label para mostrar o resultado do imc

		Label etiquetaResultado = new Label();

		// Botão para calcular o IMC

		Button botaoCalcular = new Button("Calcular IMC");
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

		// Cena e Palco

		Scene cena = new Scene(layout, 300, 250);
		palco.setTitle("Calculadora de IMC");
		palco.setScene(cena);
		palco.show();

	}

	public static void main(String[]args){
		launch(args);
	}
}

/* Melhorias para fazer:

- 	TRATAMENTO DE EXCESSÕES
			try{
			// peso
			// altura
			// calculo IMC
			// resultado
			} catch (NumberFormatException ex){
				etiqueta.Resultado.SetText("Insira Números Válidos");
			}

- 	CONVERSÃO PARA SEPARAÇÃO DE CASA DECIMAIS COM VÍRGULA
	// double peso = Double.parseDouble(campoPeso.getText().replace(",","."));
	// double peso = Double.parseDouble(campoAltura.getText().replace(",","."));



	*/

