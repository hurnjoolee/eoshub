package io.eoshub.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import io.eoshub.model.AdAirdrop;

@Repository
public interface AdAirdropMapper {

	int insertAdAirdrop(AdAirdrop adAirdrop);

	AdAirdrop getAdAirdrop(@Param("id") Integer id);

}
