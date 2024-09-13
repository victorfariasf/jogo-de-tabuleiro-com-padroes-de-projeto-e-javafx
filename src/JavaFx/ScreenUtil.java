package JavaFx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ScreenUtil {

    public static void showModal(Stage ownerStage, String fxmlPath, Object controller, String title,
            ArrayList<Jogador> jogadores, String modal, Jogador jogador) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenUtil.class.getResource(fxmlPath));
            Parent root = loader.load();

            controller = loader.getController();

            switch (modal) {
                case "ganhou":
                    if (controller instanceof ModalGanhouController) {
                        ((ModalGanhouController) controller).setJogadores(jogadores, jogador);
                    }
                    break;
                case "valoresInvalidos":
                    if (controller instanceof ModalValoresInvalidosController) {
                        ((ModalValoresInvalidosController) controller).setStage(ownerStage);
                        ((ModalValoresInvalidosController) controller).initialize(jogador);
                    }
                    break;
                /*
                 * case "naoJogar":
                 * if (controller instanceof ModalNaoJogarController) {
                 * ((ModalNaoJogarController) controller).setStage(ownerStage);
                 * ((ModalNaoJogarController) controller).desabilitarJogadaTemp(jogador);
                 * // ((ModalNaoJogarController) controller).initialize();
                 * }
                 * break;
                 */
                case "avisoNaoJoga":
                    if (controller instanceof ModalAvisoNaoJogaController) {
                        ((ModalAvisoNaoJogaController) controller).setStage(ownerStage);
                        ((ModalAvisoNaoJogaController) controller).aviso(jogador);
                    }
                    break;
                /*
                 * case "trocaPeca":
                 * if (controller instanceof ModalTrocaPecaController) {
                 * ((ModalTrocaPecaController) controller).setStage(ownerStage);
                 * ((ModalTrocaPecaController) controller).setJogador(jogador);
                 * // ((ModalTrocaPecaController) controller).initialize();
                 * }
                 * break;
                 * case "andarPraFrente":
                 * if (controller instanceof ModalAndarPraFrenteController) {
                 * ((ModalAndarPraFrenteController) controller).setStage(ownerStage);
                 * ((ModalAndarPraFrenteController) controller).isAzarado(jogador);
                 * // ((ModalAndarPraFrenteController) controller).initialize();
                 * }
                 * break;
                 * case "voltarParaInicio":
                 * if (controller instanceof ModalMandarInicioController) {
                 * ((ModalMandarInicioController) controller).setStage(ownerStage);
                 * ((ModalMandarInicioController) controller).atualizarTela(jogadores);
                 * // ((ModalMandarInicioController) controller).initialize();
                 * }
                 * break;
                 * case "trocaDeLugar":
                 * if (controller instanceof ModalMandarPraTrasController) {
                 * ((ModalMandarPraTrasController) controller).setStage(ownerStage);
                 * ((ModalMandarPraTrasController) controller).atualizarTela(jogadores,
                 * jogador);
                 * // ((ModalMandarPraTrasController) controller).initialize();
                 * }
                 * break;
                 */

                case "dadosIguais":
                    break;
                default:
                    break;
            }

            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(ownerStage);
            modalStage.setTitle(title);
            modalStage.setScene(new Scene(root));
            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void mostrarTela(Stage ownerStage, String fxmlPath, Object controller, String title,
            ArrayList<Jogador> jogadores, String modal, int jogadorAtual) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenUtil.class.getResource(fxmlPath));
            Parent root = loader.load();

            controller = loader.getController();

            switch (modal) {
                case "simples":
                    if (controller instanceof CasaSimplesModalController) {
                        ((CasaSimplesModalController) controller).setStage(ownerStage);
                        ((CasaSimplesModalController) controller).setLabels(jogadores, jogadorAtual);
                    }
                    break;
                case "surpresa":
                    if (controller instanceof CasaSurpresaModalController) {
                        ((CasaSurpresaModalController) controller).setStage(ownerStage);
                        ((CasaSurpresaModalController) controller).setLabels(jogadores, jogadorAtual);
                    }
                    break;
                case "prisao":
                    if (controller instanceof CasaPrisaoModalController) {
                        ((CasaPrisaoModalController) controller).setStage(ownerStage);
                        ((CasaPrisaoModalController) controller).setLabels(jogadores, jogadorAtual);
                        // ((ModalNaoJogarController) controller).initialize();
                    }
                    break;
                case "sorte":
                    if (controller instanceof CasaSorteModalController) {
                        ((CasaSorteModalController) controller).setStage(ownerStage);
                        ((CasaSorteModalController) controller).setLabels(jogadores, jogadorAtual);
                    }
                    break;
                case "azar":
                    if (controller instanceof CasaAzarModalController) {
                        ((CasaAzarModalController) controller).setStage(ownerStage);
                        ((CasaAzarModalController) controller).setLabels(jogadores, jogadorAtual);
                        // ((ModalTrocaPecaController) controller).initialize();
                    }
                    break;
                case "reversa":
                    if (controller instanceof CasaReversaModalController) {
                        ((CasaReversaModalController) controller).setStage(ownerStage);
                        ((CasaReversaModalController) controller).setLabels(jogadores, jogadorAtual);
                        // ((ModalAndarPraFrenteController) controller).initialize();
                    }
                    break;
                case "jogaDeNovo":
                    if (controller instanceof CasaJogarDeNovoModalController) {
                        ((CasaJogarDeNovoModalController) controller).setStage(ownerStage);
                        ((CasaJogarDeNovoModalController) controller).setLabels(jogadores, jogadorAtual);
                        // ((ModalMandarInicioController) controller).initialize();
                    }
                    break;
                case "troca":
                    if (controller instanceof CasaTrocaModalController) {
                        ((CasaTrocaModalController) controller).setStage(ownerStage);
                        ((CasaTrocaModalController) controller).setLabels(jogadores, jogadorAtual);
                        // ((ModalMandarPraTrasController) controller).initialize();
                    }
                    break;

                case "dadosIguais":
                    break;
                default:
                    break;
            }

            Stage modalStage = new Stage();
            modalStage.initModality(Modality.APPLICATION_MODAL);
            modalStage.initOwner(ownerStage);
            modalStage.setTitle(title);
            modalStage.setScene(new Scene(root));
            modalStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void show(Stage ownerStage, String fxmlPath, Object controller, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(ScreenUtil.class.getResource(fxmlPath));
            loader.setController(controller);
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.initOwner(ownerStage);
            stage.setTitle(title);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
