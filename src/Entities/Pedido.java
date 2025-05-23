public class Pedido extends Base {
    private LocalTime horaEstimadaFinalizacion;
    private double total;
    private double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    private LocalDate fechaPedido;

    public LocalTime getHoraEstimadaFinalizacion() { return horaEstimadaFinalizacion; }
    public void setHoraEstimadaFinalizacion(LocalTime horaEstimadaFinalizacion) { this.horaEstimadaFinalizacion = horaEstimadaFinalizacion; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public double getTotalCosto() { return totalCosto; }
    public void setTotalCosto(double totalCosto) { this.totalCosto = totalCosto; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public TipoEnvio getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(TipoEnvio tipoEnvio) { this.tipoEnvio = tipoEnvio; }

    public FormaPago getFormaPago() { return formaPago; }
    public void setFormaPago(FormaPago formaPago) { this.formaPago = formaPago; }

    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }
}