
import EJB.EmpresaFacadeLocal;
import Model.Empresa;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ConsultarInformacionTiendasController implements Serializable{

    @EJB
    private EmpresaFacadeLocal empresaEJB;

    private List<Empresa> listaEmpresas;
    
    private Empresa selectedEmpresa;
    
    private List<Empresa> filteredEmpresa;
    
    private int codigoTrabajador;
    private String globalFilter;
    
    private boolean globalFilterOnly;
    
    

    @PostConstruct
    public void init() {
        globalFilterOnly = false;
        listaEmpresas = empresaEJB.findAll();
        
    }

    public boolean isGlobalFilterOnly() {
        return globalFilterOnly;
    }

    public void setGlobalFilterOnly(boolean globalFilterOnly) {
        this.globalFilterOnly = globalFilterOnly;
    }

    public void toggleGlobalFilter() {
        setGlobalFilterOnly(!isGlobalFilterOnly());
    }
    
    public EmpresaFacadeLocal getEmpresaEJB() {
        return empresaEJB;
    }

    public void setEmpresaEJB(EmpresaFacadeLocal empresaEJB) {
        this.empresaEJB = empresaEJB;
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<Empresa> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public Empresa getSelectedEmpresa() {
        return selectedEmpresa;
    }

    public void setSelectedEmpresa(Empresa selectedEmpresa) {
        this.selectedEmpresa = selectedEmpresa;
    }

    public int getCodigoTrabajador() {
        return codigoTrabajador;
    }

    public void setCodigoTrabajador(int codigoTrabajador) {
        this.codigoTrabajador = codigoTrabajador;
    }

    public String getGlobalFilter() {
        return globalFilter;
    }

    public void setGlobalFilter(String globalFilter) {
        this.globalFilter = globalFilter;
    }

    public List<Empresa> getFilteredEmpresa() {
        return filteredEmpresa;
    }

    public void setFilteredEmpresa(List<Empresa> filteredEmpresa) {
        this.filteredEmpresa = filteredEmpresa;
    }
    
}
