import java.util.ArrayList;

public class Biblioteca {
    private static final String DATA_PADRAO = "10/09/2025";

   
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    
    public void adicionarLivro(String titulo, String autor, int ano) {
        Livro novoLivro = new Livro(titulo, autor, ano);
        livros.add(novoLivro);
    }

    private Livro buscarLivroDisponivel(String tituloLivro) {
        for (Livro livro : livros) { 
            if (livro.getTitulo().equals(tituloLivro) && livro.isDisponivel()) {
                return livro;
            }
        }
        return null;
    }

    public void realizarEmprestimo(Usuario usuario, String tituloLivro) { 
        Livro livroEncontrado = buscarLivroDisponivel(tituloLivro);

        if (livroEncontrado != null) {
            Emprestimo novoEmprestimo = new Emprestimo(usuario, livroEncontrado, DATA_PADRAO);
            emprestimos.add(novoEmprestimo);
            livroEncontrado.setDisponivel(false);
            System.out.println("Empréstimo realizado: " + usuario.getNome() + " pegou " + livroEncontrado.getTitulo());
        } else {
            System.out.println("Livro não disponível.");
        }
    }

    public void listarEmprestimos() {
        for (Emprestimo emprestimo : emprestimos) { 
            System.out.println(emprestimo.formatarDados());
        }
    }

    public void relatorioLivros() {
        for (Livro livro : livros) { 
            System.out.println(livro.formatarDados());
        }
    }
}