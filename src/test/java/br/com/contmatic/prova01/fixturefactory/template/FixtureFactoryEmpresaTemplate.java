package br.com.contmatic.prova01.fixturefactory.template;

import br.com.contmatic.prova01.model.Departamento;
import br.com.contmatic.prova01.model.Empresa;
import br.com.contmatic.types.TelefoneType;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class FixtureFactoryEmpresaTemplate implements TemplateLoader {
    @Override
    public void load() {
        Fixture.of(Empresa.class).addTemplate("EmpresaValida", new Rule() {
            {
                add("razaoSocial", random("Carrefour Raz. Social", "Extra Raz. Social", "Tauste Raz. Social"));
                add("nomeFantasia", random("Carrefour Nome Fantasia", "Extra Nome Fantasia", "Tauste Nome Fantasia"));
                add("cnpj", cnpj());
                add("inscricaoEstadual", random("935.995.860.240", "995.935.860.240", "935.995.240.860"));
                add("endereco", random("Rua Padre Estevão Pernet", "Rua Giovani Fabri", "Avenida Paulista"));
                add("departamentos", fixture(Departamento.class, "valido"));
                add("tipoTelefone", random(TelefoneType.COMERCIAL, TelefoneType.CELULAR, TelefoneType.TRABALHO));
                add("telefone", random("11-3269-8974", "15-3224-8954", "19-32147-5691"));
                add("email", random("fabiorubim@hotmail.com", "rubimfabio@gmail.com", "fabio.rubim-terceiros@contmatic.com.br"));
                add("url", random("www.contmatic.com.br", "www.google.com.br", "www.extra.com.br"));
            }
        });

        Fixture.of(Departamento.class).addTemplate("valido", new Rule() {
            {
                add("nome", random("Recursos humanos", "Tecnolgia", "Financeiro"));
            }
        });
    }
}
