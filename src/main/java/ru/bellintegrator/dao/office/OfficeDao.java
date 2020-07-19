package ru.bellintegrator.dao.office;



import ru.bellintegrator.model.office.Office;

import java.util.List;
import java.util.Map;

public interface OfficeDao {

    /**
     * Получить все объекты Office
     *
     * @return
     */
    List<Office> all();

    /**
     * Получить все объекты Office по параметрам
     *
     * @return
     */
    List<Office> allByParam(Map<String, String> params, Boolean isActive);

    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    Office loadById(Long id);

    /**
     * Сохранить Office
     *
     * @param office
     */
    void save(Office office);
}
