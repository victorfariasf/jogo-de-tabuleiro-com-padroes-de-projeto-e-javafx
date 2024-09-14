package JavaFx;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.application.Platform;

public class PartidaController {

    ArrayList<String> jogadores = new ArrayList<>();
    ArrayList<Jogador> jogadoresObj = new ArrayList<>();
    Fachada fachada = new Fachada(getStage());

    @FXML
    protected void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("partida")) {
                    System.out.println("nova tela: " + newScreen + " ," + userData);
                    if (userData instanceof Fachada) {
                        System.out.println("entrou no if da partidaCOntroller");
                        jogadoresObj = fachada.pegarListaDeJogadores();

                        jogador1.setText("");
                        jogador2.setText("");
                        jogador3.setText("");
                        jogador4.setText("");
                        jogador5.setText("");
                        jogador6.setText("");

                        posicao1.setText("");
                        posicao2.setText("");
                        posicao3.setText("");
                        posicao4.setText("");
                        posicao5.setText("");
                        posicao6.setText("");

                        atualizarMenuDeLado();

                    } else {
                        System.out.println("O userData não é um ArrayList<String>");
                    }
                    // tabuleiro.adicionarJogadores();
                    atualizarVezDoJogador();

                    if (fachada.modoDebug() == false) {
                        continuarBtn.setDisable(true);
                        escolhaDaCasaLabel.setDisable(true);
                        rolarDados.setDisable(false);
                        passarJogada.setDisable(false);
                    } else {
                        continuarBtn.setDisable(false);
                        escolhaDaCasaLabel.setDisable(false);
                        rolarDados.setDisable(true);
                        passarJogada.setDisable(true);
                    }
                }
            }
        });
    }

    @FXML
    private Button continuarBtn;

    @FXML
    private TextField escolhaDaCasaLabel;

    @FXML
    private Circle corDoJogador;

    @FXML
    private Label dado1;

    @FXML
    private Label dado2;

    @FXML
    private Label jogador1;

    @FXML
    private Label jogador2;

    @FXML
    private Label jogador3;

    @FXML
    private Label jogador4;

    @FXML
    private Label jogador5;

    @FXML
    private Label jogador6;

    @FXML
    private Button passarJogada;

    @FXML
    private Label qualRodada;

    @FXML
    private Button rolarDados;

    @FXML
    private Label vezDoJogadorX;

    @FXML
    private Label posicao1;

    @FXML
    private Label posicao2;

    @FXML
    private Label posicao3;

    @FXML
    private Label posicao4;

    @FXML
    private Label posicao5;

    @FXML
    private Label posicao6;

    @FXML
    private Label posicaoJogadorAtual;

    @FXML
    private Label somaDosDados;

    @FXML
    private ImageView imagemDaPeca;
    @FXML
    private ImageView imagemBone;
    @FXML
    private ImageView imagemOculos;
    @FXML
    private ImageView imagemMoletom;
    @FXML
    private Label descricaoJogadorLabel;

    private int rodadaAtual = 1;
    private int jogadorAtual = 0;
    // private boolean fimDeJogo = false;
    // private Tabuleiro tabuleiro = new Tabuleiro(jogadoresObj.size());

    public void atualizarVezDoJogador() {

        System.out.println("rodada atual: " + rodadaAtual);
        System.out.println("rodad que pode jogar sem pagar: " + jogadoresObj.get(jogadorAtual).getRodadaQuePodeJogar());

        ArrayList<String> cores = new ArrayList<>() {
            {
                add("azul");
                add("preto");
                add("amarelo");
                add("roxo");
                add("verde");
            }
        };

        vezDoJogadorX.setText("Vez do jogador " + jogadoresObj.get(jogadorAtual).getNome() + " - "
                + jogadoresObj.get(jogadorAtual).getTipo());
        posicaoJogadorAtual.setText("Posição atual: " + jogadoresObj.get(jogadorAtual).getPosicao());
        descricaoJogadorLabel.setText(jogadoresObj.get(jogadorAtual).getDescricao());

        for (String x : cores) {
            if (jogadoresObj.get(jogadorAtual).getCor().equals(x)) {
                switch (x) {
                    case "azul" -> {
                        Image imagem = new Image(
                                getClass().getResourceAsStream("./images/imagens_da_peca/" + x + ".png"));
                        imagemDaPeca.setImage(imagem);
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("bone")) {
                            Image iBone = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/bone.png"));
                            imagemBone.setImage(iBone);
                        } else {
                            Image iBoneVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemBone.setImage(iBoneVazio);
                        }

                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("oculos")) {
                            Image iOculos = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/oculos.png"));
                            imagemOculos.setImage(iOculos);
                        } else {
                            Image iOculosVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemOculos.setImage(iOculosVazio);
                        }

                        // Verificar se o jogador tem moletom
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("moleton")) {
                            Image iMoleton = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/moletom.png"));
                            imagemMoletom.setImage(iMoleton);
                        } else {
                            Image iMoletonVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemMoletom.setImage(iMoletonVazio);
                        }

                        break;
                    }
                    case "preto" -> {
                        Image imagem = new Image(
                                getClass().getResourceAsStream("./images/imagens_da_peca/" + x + ".png"));
                        imagemDaPeca
                                .setImage(imagem);
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("bone")) {
                            Image iBone = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/bone.png"));
                            imagemBone.setImage(iBone);
                        } else {
                            Image iBoneVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemBone.setImage(iBoneVazio);
                        }

                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("oculos")) {
                            Image iOculos = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/oculos.png"));
                            imagemOculos.setImage(iOculos);
                        } else {
                            Image iOculosVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemOculos.setImage(iOculosVazio);
                        }

                        // Verificar se o jogador tem moletom
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("moleton")) {
                            Image iMoleton = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/moletom.png"));
                            imagemMoletom.setImage(iMoleton);
                        } else {
                            Image iMoletonVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemMoletom.setImage(iMoletonVazio);
                        }
                        break;
                    }
                    case "amarelo" -> {
                        Image imagem = new Image(
                                getClass().getResourceAsStream("./images/imagens_da_peca/" + x + ".png"));
                        imagemDaPeca
                                .setImage(imagem);
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("bone")) {
                            Image iBone = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/bone.png"));
                            imagemBone.setImage(iBone);
                        } else {
                            Image iBoneVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemBone.setImage(iBoneVazio);
                        }

                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("oculos")) {
                            Image iOculos = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/oculos.png"));
                            imagemOculos.setImage(iOculos);
                        } else {
                            Image iOculosVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemOculos.setImage(iOculosVazio);
                        }

                        // Verificar se o jogador tem moletom
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("moleton")) {
                            Image iMoleton = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/moletom.png"));
                            imagemMoletom.setImage(iMoleton);
                        } else {
                            Image iMoletonVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemMoletom.setImage(iMoletonVazio);
                        }
                        break;
                    }
                    case "roxo" -> {
                        Image imagem = new Image(
                                getClass().getResourceAsStream("./images/imagens_da_peca/" + x + ".png"));
                        imagemDaPeca
                                .setImage(imagem);
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("bone")) {
                            Image iBone = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/bone.png"));
                            imagemBone.setImage(iBone);
                        } else {
                            Image iBoneVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemBone.setImage(iBoneVazio);
                        }

                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("oculos")) {
                            Image iOculos = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/oculos.png"));
                            imagemOculos.setImage(iOculos);
                        } else {
                            Image iOculosVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemOculos.setImage(iOculosVazio);
                        }

                        // Verificar se o jogador tem moletom
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("moleton")) {
                            Image iMoleton = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/moletom.png"));
                            imagemMoletom.setImage(iMoleton);
                        } else {
                            Image iMoletonVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemMoletom.setImage(iMoletonVazio);
                        }
                        break;
                    }
                    case "verde" -> {
                        Image imagem = new Image(
                                getClass().getResourceAsStream("./images/imagens_da_peca/" + x + ".png"));
                        imagemDaPeca
                                .setImage(imagem);
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("bone")) {
                            Image iBone = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/bone.png"));
                            imagemBone.setImage(iBone);
                        } else {
                            Image iBoneVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemBone.setImage(iBoneVazio);
                        }

                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("oculos")) {
                            Image iOculos = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/oculos.png"));
                            imagemOculos.setImage(iOculos);
                        } else {
                            Image iOculosVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemOculos.setImage(iOculosVazio);
                        }

                        // Verificar se o jogador tem moletom
                        if (jogadoresObj.get(jogadorAtual).getDescricao().contains("moleton")) {
                            Image iMoleton = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/moletom.png"));
                            imagemMoletom.setImage(iMoleton);
                        } else {
                            Image iMoletonVazio = new Image(
                                    getClass().getResourceAsStream("./images/imagens_da_peca/vazio.png"));
                            imagemMoletom.setImage(iMoletonVazio);
                        }
                        break;
                    }

                    default -> {
                        break;
                    }
                }
            }
        }
        qualRodada.setText("Rodada " + rodadaAtual);

    }

    public void atualizarMenuDeLado() {
        int i = 0;
        for (Jogador jogador : jogadoresObj) {
            switch (i) {
                case 0:
                    jogador1.setText(jogador.getNome());
                    posicao1.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 1:
                    jogador2.setText(jogador.getNome());
                    posicao2.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 2:
                    jogador3.setText(jogador.getNome());
                    posicao3.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 3:
                    jogador4.setText(jogador.getNome());
                    posicao4.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 4:
                    jogador5.setText(jogador.getNome());
                    posicao5.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 5:
                    jogador6.setText(jogador.getNome());
                    posicao6.setText("Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                default:
                    break;
            }
            i++;
        }

        dado1.setText("Dado 1 ->");
        dado2.setText("Dado 2 ->");
        somaDosDados.setText("Soma dos dados: ");
    }

    @FXML
    void passarJogadaAction(ActionEvent event) {

        jogadoresObj = fachada.pegarListaDeJogadores();

        for (Jogador x : jogadoresObj) {
            System.out.println(x.getDescricao());
        }

        if (jogadoresObj.get(jogadorAtual).isJogarNovamente() == true) {
            jogadoresObj.get(jogadorAtual).setJogarNovamente(false);
            rodadaAtual++;

        } else {
            jogadorAtual++;
            if (jogadorAtual >= jogadoresObj.size()) {
                jogadorAtual = 0;
                rodadaAtual++;
            }
        }

        atualizarMenuDeLado();
        atualizarVezDoJogador();
    }

    /*
     * f (fachada.verificaPodeJogarPartidaAtual(jogadoresObj.get(jogadorAtual),
     * rodadaAtual, getStage())) {
     * PauseTransition delay = new PauseTransition(Duration.seconds(2));
     * delay.setOnFinished(e -> passarJogadaAction(event));
     * delay.play();
     * }
     */

    @FXML
    void rolarDadosAction(ActionEvent event) {
        if (fachada.jogadorPodeJogar(rodadaAtual, jogadorAtual) == false) {
            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> passarJogadaAction(event));
            delay.play();
        } else {
            Dado dado = new Dado(6);
            int valorDado1 = dado.rolarDado();
            int valorDado2 = dado.rolarDado();
            int somaDosValores = valorDado1 + valorDado2;

            String stringDado1 = Integer.toString(valorDado1);
            String stringDado2 = Integer.toString(valorDado2);
            String somaDados = Integer.toString(somaDosValores);
            dado1.setText("Dado 1 ->" + stringDado1);
            dado2.setText("Dado 2 ->" + stringDado2);
            somaDosDados.setText("Soma dos dados: " + somaDados);

            PauseTransition transicaoMostrarDados = new PauseTransition(Duration.seconds(1));
            transicaoMostrarDados.setOnFinished(e1 -> {
                if (fachada.verificarJogadaInvalida(jogadoresObj.get(jogadorAtual), valorDado1, valorDado2,
                        getStage())) {
                    PauseTransition delay = new PauseTransition(Duration.seconds(1));
                    delay.setOnFinished(e -> passarJogadaAction(event));
                    delay.play();
                } else {
                    // jogadoresObj.get(jogadorAtual).mover(somaDosValores);
                    // jogadoresObj.get(jogadorAtual).setJogadas(1);
                    // tabuleiro.AndarNoTabuleiro(jogadoresObj.get(jogadorAtual), somaDosValores);
                    fachada.andarNoTabuleiro(jogadorAtual, somaDosValores, rodadaAtual);
                    boolean fimDeJogo = fachada.verificaSeAlguemGanhou(jogadorAtual);
                    if (fimDeJogo == true) {
                        fachada.mostrarTelaFinal(jogadorAtual);
                    } else {
                        fachada.mostrarTela(jogadorAtual, rodadaAtual);
                        // debug
                        fachada.mostrarDescricoes();
                        PauseTransition delay = new PauseTransition(Duration.seconds(1));
                        delay.setOnFinished(e -> passarJogadaAction(event));
                        delay.play();
                    }

                }
            });
            transicaoMostrarDados.play();

        }
    }

    @FXML
    void continuarOnAction(ActionEvent event) {

    }

    public Stage getStage() {
        return Main.getStage();
    }

    /*
     * private void avisoNaoJogar(Jogador jogador) {
     * Platform.runLater(() -> {
     * ModalAvisoNaoJogaController controller = new ModalAvisoNaoJogaController();
     * ScreenUtil.showModal(getStage(), "./fxml/modalAvisoNaoJoga.fxml", controller,
     * "Rodada sem jogar", null,
     * "avisoNaoJoga",
     * jogador);
     * });
     * }
     */

    /*
     * private void ganhou(ArrayList<Jogador> jogadores) {
     * Platform.runLater(() -> {
     * // showModalGanhou(jogadores);
     * ModalGanhouController controller = new ModalGanhouController();
     * ScreenUtil.showModal(getStage(), "./fxml/modalGanhou.fxml", controller,
     * "Fim de jogo", jogadores, "ganhou",
     * null);
     * });
     * }
     * 
     * private void valoresInvalidos(Jogador jogador) {
     * Platform.runLater(() -> {
     * ModalValoresInvalidosController controller = new
     * ModalValoresInvalidosController();
     * ScreenUtil.showModal(getStage(), "./fxml/modalValoresInvalidos.fxml",
     * controller, "Dados inválidos", null,
     * "valoresInvalidos", jogador);
     * });
     * }
     * 
     * private void naoJogar(Jogador jogador) {
     * Platform.runLater(() -> {
     * ModalNaoJogarController controller = new ModalNaoJogarController();
     * ScreenUtil.showModal(getStage(), "./fxml/ModalNaoJogar.fxml", controller,
     * "Rodada sem jogar", null,
     * "naoJogar",
     * jogador);
     * });
     * }
     * 
     * private void trocaPeca(Jogador jogador) {
     * Platform.runLater(() -> {
     * ModalTrocaPecaController controller = new ModalTrocaPecaController();
     * ScreenUtil.showModal(getStage(), "./fxml/modalTrocaPeca.fxml", controller,
     * "Trocar peça", null, "trocaPeca",
     * jogador);
     * });
     * }
     * 
     * private void andarPraFrente(Jogador jogador) {
     * Platform.runLater(() -> {
     * ModalAndarPraFrenteController controller = new
     * ModalAndarPraFrenteController();
     * ScreenUtil.showModal(getStage(), "./fxml/modalAndarPraFrente.fxml",
     * controller, "Andar pra frente", null,
     * "andarPraFrente", jogador);
     * });
     * }
     * 
     * private void mandarInicio(ArrayList<Jogador> jogadores) {
     * Platform.runLater(() -> {
     * ModalMandarInicioController controller = new ModalMandarInicioController();
     * ScreenUtil.showModal(getStage(), "./fxml/modalMandarInicio.fxml", controller,
     * "Mandar para o início",
     * jogadores, "voltarParaInicio", null);
     * });
     * }
     * 
     * public void mandarPraTras(ArrayList<Jogador> jogadores, Jogador jogador) {
     * Platform.runLater(() -> {
     * ModalMandarPraTrasController controller = new ModalMandarPraTrasController();
     * ScreenUtil.showModal(getStage(), "./fxml/modalMandarPraTras.fxml",
     * controller,
     * "Trocar de posição com o jogador mais atrás", jogadores, "trocaDeLugar",
     * jogador);
     * });
     * }
     * 
     * public void casaEspecial(Jogador jogador) {
     * Platform.runLater(() -> {
     * switch (jogador.getPosicao()) {
     * case 10, 25, 38 -> {
     * System.out.println("Casa Especial - Não pode jogar na próxima rodada");
     * jogador.setQualRodadaNaoPodeJogar(rodadaAtual + 1);
     * naoJogar(jogador);
     * }
     * case 13 -> {
     * System.out.println("Casa Especial - Trocar tipo de peça");
     * trocaPeca(jogador);
     * }
     * case 5, 15, 30 -> {
     * System.out.println("Casa Especial - Andar três casas para frente");
     * andarPraFrente(jogador);
     * }
     * case 17, 27 -> {
     * System.out.println("Casa Especial - Manda um jogador para o início do jogo");
     * mandarInicio(jogadoresObj);
     * }
     * case 20, 35 -> {
     * System.out.println("Casa Especial - Trocar de lugar com o jogador mais atrás"
     * );
     * mandarPraTras(jogadoresObj, jogador);
     * }
     * default -> {
     * System.out.println("Não caiu em nenhuma casa especial");
     * }
     * }
     * });
     * }
     */

}
