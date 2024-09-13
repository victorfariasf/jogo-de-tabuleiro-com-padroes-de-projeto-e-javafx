/*
 * package JavaFx;
 * 
 * import java.util.ArrayList;
 * import java.util.Random;
 * 
 * import javafx.application.Platform;
 * import javafx.stage.Stage;
 * 
 * public class Auxiliar {
 * 
 * private JogadorFactory azaradoFactory = new AzaradoFactory();
 * private JogadorFactory sortudoFactory = new SortudoFactory();
 * private JogadorFactory comumFactory = new ComumFactory();
 * 
 * private ArrayList<Jogador> jogadores = new ArrayList<>();
 * 
 * public void setJogares(ArrayList<Jogador> jogadores) {
 * this.jogadores = jogadores;
 * }
 * // -----------------------Criar jogadores-------------------------
 * 
 * public Jogador criarJogadores(String nome, String cor) {
 * Random randomizador = new Random();
 * int indiceRandomizado = randomizador.nextInt(3) + 1;
 * switch (indiceRandomizado) {
 * case 1 -> {
 * return azaradoFactory.criarJogador(nome, cor, 0, 0);
 * }
 * case 2 -> {
 * return sortudoFactory.criarJogador(nome, cor, 0, 0);
 * }
 * case 3 -> {
 * return comumFactory.criarJogador(nome, cor, 0, 0);
 * }
 * default -> {
 * return comumFactory.criarJogador(nome, cor, 0, 0);
 * }
 * }
 * }
 * 
 * public Jogador decorarJogador(Jogador jogador) {
 * if (!jogador.getDescricao().contains("bone")) {
 * return new BoneDecorator(jogador);
 * } else if (!jogador.getDescricao().contains("oculos")) {
 * return new OculosDecorator(jogador);
 * } else if (!jogador.getDescricao().contains("moleton")) {
 * return new MoletonDecorator(jogador);
 * } else {
 * return jogador;
 * }
 * 
 * }
 * 
 * // ---------------------------------------------------------------
 * public void casaEspecial(ArrayList<Jogador> jogadores, int jogadorAtual, int
 * rodadaAtual, Stage stage) {
 * setJogares(jogadores);
 * Platform.runLater(() -> {
 * switch (jogadores.get(jogadorAtual).getPosicao()) {
 * case 10, 25, 38 -> {
 * System.out.println("Casa Especial - Não pode jogar na próxima rodada");
 * jogadores.get(jogadorAtual).setQualRodadaNaoPodeJogar(rodadaAtual + 1);
 * naoJogar(jogadores.get(jogadorAtual), stage);
 * }
 * case 13 -> {
 * System.out.println("Casa Especial - Trocar tipo de peça");
 * substituirJogador(jogadores.get(jogadorAtual));
 * trocaPeca(jogadores.get(jogadorAtual), stage);
 * }
 * case 5, 15, 30 -> {
 * System.out.println("Casa Especial - Andar três casas para frente");
 * Jogador jogadorDecorado = decorarJogador(jogadores.get(jogadorAtual));
 * jogadores.set(jogadorAtual, jogadorDecorado);
 * andarPraFrente(jogadores.get(jogadorAtual), stage);
 * }
 * case 17, 27 -> {
 * System.out.println("Casa Especial - Manda um jogador para o início do jogo");
 * mandarInicio(jogadores, stage);
 * }
 * case 20, 35 -> {
 * System.out.println("Casa Especial - Trocar de lugar com o jogador mais atrás"
 * );
 * mandarPraTras(jogadores, jogadores.get(jogadorAtual), stage);
 * }
 * default -> {
 * System.out.println("Não caiu em nenhuma casa especial");
 * }
 * }
 * });
 * }
 * 
 * private void naoJogar(Jogador jogador, Stage stage) {
 * Platform.runLater(() -> {
 * ModalNaoJogarController controller = new ModalNaoJogarController();
 * ScreenUtil.showModal(stage, "./fxml/ModalNaoJogar.fxml", controller,
 * "Rodada sem jogar", null,
 * "naoJogar",
 * jogador);
 * });
 * }
 * 
 * private void trocaPeca(Jogador jogador, Stage stage) {
 * Platform.runLater(() -> {
 * ModalTrocaPecaController controller = new ModalTrocaPecaController();
 * ScreenUtil.showModal(stage, "./fxml/modalTrocaPeca.fxml", controller,
 * "Trocar peça", null, "trocaPeca",
 * jogador);
 * });
 * }
 * 
 * private void substituirJogador(Jogador jogador) {
 * int indice = jogadores.indexOf(jogador);
 * if (indice != -1) {
 * // Cria um novo jogador com os mesmos atributos básicos
 * Jogador novoJogador = criarJogadores(jogador.getNome(), jogador.getCor());
 * 
 * // Decora o novo jogador baseado nos acessórios que o jogador original possui
 * if (jogador.getDescricao().contains("bone")) {
 * novoJogador = new BoneDecorator(novoJogador);
 * }
 * if (jogador.getDescricao().contains("oculos")) {
 * novoJogador = new OculosDecorator(novoJogador);
 * }
 * if (jogador.getDescricao().contains("moleton")) {
 * novoJogador = new MoletonDecorator(novoJogador);
 * }
 * 
 * // Atualiza a posição e jogadas do novo jogador
 * novoJogador.setPosicao(jogador.getPosicao());
 * novoJogador.setJogadas(jogador.getJogadas());
 * 
 * // Substitui o jogador na lista
 * jogadores.set(indice, novoJogador);
 * 
 * } else {
 * System.out.println("Jogador não encontrado");
 * }
 * }
 * 
 * private void andarPraFrente(Jogador jogador, Stage stage) {
 * Platform.runLater(() -> {
 * ModalAndarPraFrenteController controller = new
 * ModalAndarPraFrenteController();
 * ScreenUtil.showModal(stage, "./fxml/modalAndarPraFrente.fxml", controller,
 * "Andar pra frente", null,
 * "andarPraFrente", jogador);
 * });
 * }
 * 
 * private void mandarInicio(ArrayList<Jogador> jogadores, Stage stage) {
 * Platform.runLater(() -> {
 * ModalMandarInicioController controller = new ModalMandarInicioController();
 * ScreenUtil.showModal(stage, "./fxml/modalMandarInicio.fxml", controller,
 * "Mandar para o início",
 * jogadores, "voltarParaInicio", null);
 * });
 * }
 * 
 * private void mandarPraTras(ArrayList<Jogador> jogadores, Jogador jogador,
 * Stage stage) {
 * Platform.runLater(() -> {
 * ModalMandarPraTrasController controller = new ModalMandarPraTrasController();
 * ScreenUtil.showModal(stage, "./fxml/modalMandarPraTras.fxml", controller,
 * "Trocar de posição com o jogador mais atrás", jogadores, "trocaDeLugar",
 * jogador);
 * });
 * }
 * 
 * // ******************************
 * 
 * /*
 * public void fimDeJogo(ArrayList<Jogador> jogadores, int jogadorAtual, Stage
 * stage) {
 * if (jogadores.get(jogadorAtual).ganhou() == true) {
 * ganhou(jogadores, stage);
 * }
 * }
 */

/*
 * private void ganhou(ArrayList<Jogador> jogadores, Stage stage) {
 * Platform.runLater(() -> {
 * // showModalGanhou(jogadores);
 * ModalGanhouController controller = new ModalGanhouController();
 * ScreenUtil.showModal(stage, "./fxml/modalGanhou.fxml", controller,
 * "Fim de jogo", jogadores, "ganhou",
 * null);
 * });
 * }
 * 
 * // ******************************
 * 
 * public boolean verificaJogadaInvalida(Jogador jogador, int dadoUm, int
 * dadoDois, Stage stage) {
 * if (jogador.validandoSomaDosDados(dadoUm, dadoDois) == false) {
 * valoresInvalidos(jogador, stage);
 * return true;
 * }
 * return false;
 * }
 * 
 * private void valoresInvalidos(Jogador jogador, Stage stage) {
 * Platform.runLater(() -> {
 * ModalValoresInvalidosController controller = new
 * ModalValoresInvalidosController();
 * ScreenUtil.showModal(stage, "./fxml/modalValoresInvalidos.fxml", controller,
 * "Dados inválidos", null,
 * "valoresInvalidos", jogador);
 * });
 * }
 * 
 * // *****************
 * 
 * public boolean verificaJogarNaPartidaAtual(Jogador jogador, int partidaAtual,
 * Stage stage) {
 * if (jogador.getQualRodadaNaoPodeJogar() == partidaAtual) {
 * avisoNaoJogar(jogador, stage);
 * return true;
 * }
 * return false;
 * }
 * 
 * private void avisoNaoJogar(Jogador jogador, Stage stage) {
 * Platform.runLater(() -> {
 * ModalAvisoNaoJogaController controller = new ModalAvisoNaoJogaController();
 * ScreenUtil.showModal(stage, "./fxml/modalAvisoNaoJoga.fxml", controller,
 * "Rodada sem jogar", null,
 * "avisoNaoJoga",
 * jogador);
 * });
 * }
 * // --------------------------------------
 * 
 * public ArrayList<Jogador> retornarListaDeJogadores() {
 * return jogadores;
 * }
 * }
 */