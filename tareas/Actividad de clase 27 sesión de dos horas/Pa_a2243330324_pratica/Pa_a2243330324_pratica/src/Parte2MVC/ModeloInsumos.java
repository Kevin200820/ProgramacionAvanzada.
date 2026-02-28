package Parte2MVC;

import Parte2.Insumo;
import Parte2.Categoria;
import Parte2.ListaInsumos;
import Parte2.ListaCategorias;

public class ModeloInsumos {
    private ListaInsumos listaInsumos;
    private ListaCategorias listaCategorias;

    public ModeloInsumos() {
        this.listaInsumos = new ListaInsumos();
        this.listaCategorias = new ListaCategorias();
        
        this.listaCategorias.agregarCategoria(new Categoria("01", "Materiales"));
        this.listaCategorias.agregarCategoria(new Categoria("02", "Mano de Obra"));
        this.listaCategorias.agregarCategoria(new Categoria("03", "Maquinaria y Equipo"));
        this.listaCategorias.agregarCategoria(new Categoria("04", "Servicios"));
    }

    public ListaInsumos getListaInsumos() { return listaInsumos; }
    public ListaCategorias getListaCategorias() { return listaCategorias; }
}