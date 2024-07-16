package com.emrekirman.glaceon.inventory.common.mapper;

import java.util.List;

public interface IBaseMapper<Req, Res, Ent> {
    Ent mapRequestToEntity(Req req);

    Res mapEntityToResponse(Ent ent);

    Req mapEntityToRequest(Ent ent);

    List<Res> mapEntityToResponseList(List<Ent> entList);

    List<Ent> mapRequestToEntityList(List<Req> resList);

    Ent mapResponseToEntity(Res res);

    List<Ent> mapResponseToEntityList(List<Res> resList);

    Req mapResponseToRequest(Res res);
}
