package br.com.armando.compravalidator.service.impl.redis;

import br.com.armando.compravalidator.dto.ClienteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CacheClienteService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void salvar(ClienteResponse cliente) {
        redisTemplate.opsForValue().set(cliente.getCpf(), cliente);
    }

    public void salvarComTimeout(ClienteResponse clienteDTO) {
        redisTemplate.opsForValue().set(clienteDTO.getCpf(), clienteDTO, 30, TimeUnit.SECONDS);
    }

    public ClienteResponse get(String identifier) {
        return (ClienteResponse) redisTemplate.opsForValue().get(identifier);
    }
}
