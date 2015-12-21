package model;

import java.io.Serializable;

public class RelationCategoriaEvento implements Serializable{
	
	private static final long serialVersionUID = 343L;
	
	private int eventoId;
	private int categoriaId;
	
	public RelationCategoriaEvento(int categoriaId, int eventoId){
		this.eventoId = eventoId;
		this.categoriaId = categoriaId;
	}

	public int getEventoId() {
		return eventoId;
	}

	public int getCategoriaId() {
		return categoriaId;
	}
	
	@Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof CategoriaEvento) {
        	RelationCategoriaEvento categoriaEventoId = (RelationCategoriaEvento) object;
            return categoriaEventoId.eventoId == this.eventoId && categoriaEventoId.categoriaId == this.categoriaId;
        }
        return false;
    }	
}