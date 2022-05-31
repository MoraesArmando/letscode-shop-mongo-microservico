package br.com.armando.compravalidator.service.impl.redis;

import br.com.armando.compravalidator.dto.ProdutoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaheProdutoService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void push(ProdutoResponse produtoDTO) {
        redisTemplate.opsForList().rightPush("produtos", produtoDTO);
    }

    public ProdutoResponse pop() {
        return (ProdutoResponse) redisTemplate.opsForList().leftPop("produtos");
    }

    public List<Object> getProdutos(long inicio, long fim) {
        return redisTemplate.opsForList().range("produtos", inicio, fim);
    }
}
