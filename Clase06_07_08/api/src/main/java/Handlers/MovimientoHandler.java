package Handlers;

import Domain.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MovimientoHandler {
    private static ArrayList<Movimiento> _movimientos = new ArrayList<Movimiento>();

    public MovimientoHandler() {
    }

    public MovimientoHandler(ArrayList<Movimiento> _movimientos) {
        this._movimientos = _movimientos;
    }

    public static ArrayList<Movimiento> getMovimientos() {
        return _movimientos;
    }

    public static ArrayList<Movimiento> getMovimientosPorTipo(FiltroMovimiento filtroMovimiento) {
        ArrayList<Movimiento> aux = new ArrayList<>();
        for (Movimiento movimiento:_movimientos) {
            if(movimiento.getFecha().compareTo(filtroMovimiento.getFechaInicio()) >= 0
                    && movimiento.getFecha().compareTo(filtroMovimiento.getFechaFin()) <= 0
                    && movimiento.getTipoMovimiento() == filtroMovimiento.getTipoMovimiento()) {
                aux.add(movimiento);
            }
        }

        return aux;
    }

    public static ArrayList<Movimiento> getMovimientosPorSubtipo(FiltroMovimiento filtroMovimiento) {
        ArrayList<Movimiento> aux = new ArrayList<>();
        for (Movimiento movimiento:_movimientos) {
            if(movimiento.getFecha().compareTo(filtroMovimiento.getFechaInicio()) >= 0
                    && movimiento.getFecha().compareTo(filtroMovimiento.getFechaFin()) <= 0
                    && movimiento.getSubtipoMovimiento().getId() == filtroMovimiento.getSubtipo()) {
                aux.add(movimiento);
            }
        }

        return aux;
    }

    public static Movimiento getMovimiento(int id) {
        for (Movimiento movimiento:_movimientos) {
            if ( movimiento.getId() == id ) {
                return movimiento;
            }
        }
        return null;
    }

    public static Movimiento deleteMovimiento(int id) {
        for (int i = 0; i < _movimientos.size(); i++) {
            if ( _movimientos.get(i).getId() == id ) {
                return _movimientos.remove(i);
            }
        }

        return null;
    }

    public static Movimiento updateMovimiento(int id, Movimiento _movimiento) {
        int indexUpdate = -1;

        for (int i = 0; i < _movimientos.size(); i++) {
            if ( _movimientos.get(i).getId() == id ) {
                indexUpdate = i;
                break;
            }
        }

        if (indexUpdate != -1) {
            if (_movimiento.getSubtipoMovimiento() != null) {
                _movimiento.setSubtipoMovimiento(
                        SubtipoMovimientoHandler.getSubtipoMovimiento(
                                _movimiento.getSubtipoMovimiento().getId()
                        )
                );
            }

            if (_movimiento.getMoneda() != null) {
                _movimiento.setMoneda(
                        MonedaHandler.getMoneda(
                                _movimiento.getMoneda().getId()
                        )
                );
            }

            if (_movimiento.getTipoPago() != null) {
                _movimiento.setTipoPago(
                        TipoPagoHandler.getTipoPago(
                                _movimiento.getTipoPago().getId()
                        )
                );
            }

            if (_movimiento.getCliente() != null) {
                _movimiento.setCliente(
                        ClienteHandler.getCliente(
                                _movimiento.getCliente().getId()
                        )
                );
            }

            if (_movimiento.getProveedor() != null) {
                _movimiento.setProveedor(
                        ProveedorHandler.getProveedor(
                                _movimiento.getProveedor().getId()
                        )
                );
            }

            if (_movimiento.getSubtipoMovimiento() == null ||
                    _movimiento.getMoneda() == null ||
                    _movimiento.getTipoPago() == null ||
                    (_movimiento.getCliente() == null && _movimiento.getProveedor() == null)) {
                return null;
            }

            _movimiento.setCotizacion(_movimiento.getMoneda().getCotizacion());

            _movimiento.setId(_movimientos.get(indexUpdate).getId());
            _movimientos.set(indexUpdate, _movimiento);
            return _movimiento;
        }

        return null;
    }

    public static Movimiento addMovimiento(Movimiento _movimiento) {

        if (_movimiento.getSubtipoMovimiento() != null) {
            _movimiento.setSubtipoMovimiento(
                    SubtipoMovimientoHandler.getSubtipoMovimiento(
                            _movimiento.getSubtipoMovimiento().getId()
                    )
            );
        }

        if (_movimiento.getMoneda() != null) {
            _movimiento.setMoneda(
                    MonedaHandler.getMoneda(
                            _movimiento.getMoneda().getId()
                    )
            );
        }

        if (_movimiento.getTipoPago() != null) {
            _movimiento.setTipoPago(
                    TipoPagoHandler.getTipoPago(
                            _movimiento.getTipoPago().getId()
                    )
            );
        }

        if (_movimiento.getCliente() != null) {
            _movimiento.setCliente(
                    ClienteHandler.getCliente(
                            _movimiento.getCliente().getId()
                    )
            );
        }

        if (_movimiento.getProveedor() != null) {
            _movimiento.setProveedor(
                    ProveedorHandler.getProveedor(
                            _movimiento.getProveedor().getId()
                    )
            );
        }

        if (_movimiento.getSubtipoMovimiento() == null ||
            _movimiento.getMoneda() == null ||
            _movimiento.getTipoPago() == null ||
            (_movimiento.getCliente() == null && _movimiento.getProveedor() == null)) {
            return null;
        }

        _movimiento.setCotizacion(_movimiento.getMoneda().getCotizacion());

        int newId = _movimientos.size() == 0 ? 1:_movimientos.get(_movimientos.size() - 1).getId() + 1;
        _movimiento.setId(newId);
        _movimientos.add(_movimiento);
        return _movimiento;
    }

    public static ArrayList<Movimiento> addMovimientos(ArrayList<Movimiento> _movimientos) {
        for (int i = 0; i < _movimientos.size(); i++) {
            _movimientos.set(i, MovimientoHandler.addMovimiento(_movimientos.get(i)));
        }

        return _movimientos;
    }

    public static ArrayList<DeudaXPersona> deudaXAcreedor(FiltroMovimiento filtroMovimiento) {
        HashMap<String, DeudaXPersona> auxClientes = new HashMap<String, DeudaXPersona>();
        HashMap<String, DeudaXPersona> auxProveedores = new HashMap<String, DeudaXPersona>();

        for (Movimiento movimiento: _movimientos) {
            if(movimiento.getFecha().compareTo(filtroMovimiento.getFechaInicio()) >= 0 &&
               movimiento.getFecha().compareTo(filtroMovimiento.getFechaFin()) <= 0) {
                if (movimiento.getCliente() != null) {
                    String key = movimiento.getCliente().getId() + "c";

                    DeudaXPersona existe = auxClientes.get(key);
                    if (existe == null) {
                        existe = new DeudaXPersona(movimiento.getCliente(), null, 0);
                    }

                    if (movimiento.getTipoMovimiento() == Movimiento.INGRESO) {
                        existe.setDeuda(existe.getDeuda() - movimiento.getMonto());
                    } else {
                        existe.setDeuda(existe.getDeuda() + movimiento.getMonto());
                    }

                    auxClientes.put(key, existe);

                } else if (movimiento.getProveedor() != null) {
                    String key = movimiento.getProveedor().getId() + "p";

                    DeudaXPersona existe = auxProveedores.get(key);
                    if (existe == null) {
                        existe = new DeudaXPersona(null, movimiento.getProveedor(), 0);
                    }

                    if (movimiento.getTipoMovimiento() == Movimiento.INGRESO) {
                        existe.setDeuda(existe.getDeuda() + movimiento.getMonto());
                    } else {
                        existe.setDeuda(existe.getDeuda() - movimiento.getMonto());
                    }

                    auxProveedores.put(key, existe);
                }
            }
        }


        auxClientes.putAll(auxProveedores);
        Collection<DeudaXPersona> values = auxClientes.values();
        return new ArrayList<DeudaXPersona>(values);
    }
}
