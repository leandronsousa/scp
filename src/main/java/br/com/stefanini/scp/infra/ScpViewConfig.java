package br.com.stefanini.scp.infra;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import com.ocpsoft.pretty.faces.annotation.URLMappings;

/**
 * @author leandro
 *
 */
@URLMappings(mappings = {
		@URLMapping(id = "index", pattern = "/index", viewId = "/index.jsf"),
		@URLMapping(id = "home", pattern = "/home", viewId = "/home.jsf"),
		@URLMapping(id = "pessoas", pattern = "/pessoas", viewId = "/pages/pessoa/pessoas-list.xhtml"),
		@URLMapping(id = "pessoasForm", pattern = "/pessoas/#{parametro}", viewId = "/pages/pessoa/pessoa-form.xhtml"),
		@URLMapping(id = "pessoasEdit", pattern = "/pessoas/#{parametro}/#{id}", viewId = "/pages/pessoa/pessoa-form.xhtml")
		})
public class ScpViewConfig {

}
