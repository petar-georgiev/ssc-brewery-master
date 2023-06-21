package guru.sfg.brewery.web.controllers.api;

import guru.sfg.brewery.web.controllers.BaseIT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class BeerRestControllerIT extends BaseIT {

    @Test
    void deleteBeerUrl() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/7d6bb679-5a0a-4fca-892b-3f46534f32ee")
                        .param("apiKey", "spring").param("apiSecret", "guru"))
                .andExpect(status().isOk());
    }
    @Test
    void deleteBeerBadCredsUrl() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/7d6bb679-5a0a-4fca-892b-3f46534f32ee")
                        .param("apiKey", "spring").param("apiSecret", "wrongpass"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    void deleteBeerBadCreds() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/7d6bb679-5a0a-4fca-892b-3f46534f32ee")
                        .header("Api-Key", "spring").header("Api-Secret", "wrongpass"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    void deleteBeer() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/7d6bb679-5a0a-4fca-892b-3f46534f32ee")
                       .header("Api-Key", "spring").header("Api-Secret", "guru"))
                .andExpect(status().isOk());
    }
    @Test
    void deleteBeerHttpBasic() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/7d6bb679-5a0a-4fca-892b-3f46534f32ee")
                        .with(httpBasic("spring", "guru")))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    void deleteBeerNoAuth() throws Exception {
        mockMvc.perform(delete("/api/v1/beer/7d6bb679-5a0a-4fca-892b-3f46534f32ee"))
                .andExpect(status().isUnauthorized());
    }
    @Test
    void findBeers() throws Exception{
        mockMvc.perform(get("/api/v1/beer"))
                .andExpect(status().isOk());
    }

    @Test
    void findBeerById() throws Exception{
        mockMvc.perform(get("/api/v1/beer/7d6bb679-5a0a-4fca-892b-3f46534f32ee"))
                .andExpect(status().isOk());
    }

    @Test
    void findBeerByUpc() throws Exception{
        mockMvc.perform(get("/api/v1/beerUpc/0083783375213"))
                .andExpect(status().isOk());
    }
}
