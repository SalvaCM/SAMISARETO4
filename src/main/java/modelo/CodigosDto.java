package modelo;

public class CodigosDto {
	
	private String codigo;
	private float porcentaje;

	
	public CodigosDto(String codigo, float porcentaje) {
		this.codigo = codigo;
		this.porcentaje = porcentaje;
	}
	
	public CodigosDto() {
		
	}
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	
}
