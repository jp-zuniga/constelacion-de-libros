package org.ConstelacionDeLibros.config;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDate;

public
class AuditoriaListener {
    @PrePersist
    public
    void prePersist(Object obj) {
        if (obj instanceof Auditable) {
            Auditable a = (Auditable) obj;
            a.getAuditoria().setUsuarioIng("AdminIng");
            a.getAuditoria().setFechaIng(LocalDate.now());
        }
    }

    @PreUpdate
    public
    void preUpdate(Object obj) {
        if (obj instanceof Auditable) {
            Auditable a = (Auditable) obj;
            a.getAuditoria().setUsuarioAct("AdminMod");
            a.getAuditoria().setFechaAct(LocalDate.now());
        }
    }
}
