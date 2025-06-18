package br.com.alura.adopetstore.email;

import br.com.alura.adopetstore.dto.PedidoDTO;
import br.com.alura.adopetstore.dto.RelatorioEstoque;
import br.com.alura.adopetstore.dto.RelatorioFaturamento;
import br.com.alura.adopetstore.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailRelatorioGerado {
    @Autowired
    private EnviadorEmail enviador;


    public void enviar(RelatorioEstoque estoque, RelatorioFaturamento faturamento) {
        enviador.enviarEmail(
                "Relatórios gerados", "admin@email.com",
                """
                        Olá
                        
                        Seus relatórios foram gerados e seguem abaixo!
                        
                        %s
                        
                        
                        %s
                """.formatted(estoque, faturamento));
    }
}
