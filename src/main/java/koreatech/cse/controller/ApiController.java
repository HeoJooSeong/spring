package koreatech.cse.controller;
import koreatech.cse.domain.book.KakaoBook;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/api")
public class ApiController{
    public static String kakao_book_rest_uri = "https://dapi.kakao.com/v3/search/book?target=title";

    public static String kakao_rest_api_app_key = "e6af06c501149f8ab6fce74f0550ac3a";   //본인 것으로 추가하기

    @RequestMapping("/map")
    public String map(Model model) {

        return "map";
    }


    @RequestMapping(value = "/kakao_book", method = RequestMethod.GET)
    public String kakaoBook(Model model, @RequestParam(name = "searchWord") String searchWord) throws UnsupportedEncodingException {
        RestTemplate restTemplate = new RestTemplate();
        KakaoBook kakaoBook = null;
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Authorization", "KakaoAK " + kakao_rest_api_app_key);

            ResponseEntity<KakaoBook> kakaoBookResponseEntity = restTemplate.exchange(
                    kakao_book_rest_uri + "&query=" + searchWord,
                    HttpMethod.GET,
                    new HttpEntity<>(headers),
                    KakaoBook.class
            );

            kakaoBook = kakaoBookResponseEntity.getBody();
            System.out.println("!!!! " + kakaoBook);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getStatusCode() + ": " + e.getStatusText());
        }
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("kakaoBook", kakaoBook);
        return "kakaoBook";
    }
}

