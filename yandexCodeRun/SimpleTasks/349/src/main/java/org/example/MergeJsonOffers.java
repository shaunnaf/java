package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class MergeJsonOffers {

  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    ObjectMapper objectMapper = new ObjectMapper();
    ArrayNode mergedOffers = objectMapper.createArrayNode();
    HashSet<Integer> seenSkus = new HashSet<>();

    // Читаем количество входных строк и максимальное число SKU
    int countStrings = scanner.nextInt();
    int countOutMarkets = scanner.nextInt();
    scanner.nextLine(); // Переход на новую строку

    for (int i = 0; i < countStrings; i++) {
      String jsonArray = scanner.nextLine().trim();
      if (jsonArray.isEmpty()) {
        continue;
      }

      JsonNode rootNode = objectMapper.readTree(jsonArray);
      ArrayNode offers = (ArrayNode) rootNode.get("offers");

      for (JsonNode offer : offers) {
        int marketSku = offer.get("market_sku").asInt();

        if (!seenSkus.contains(marketSku)) {
          seenSkus.add(marketSku);

          // Создаём новый JSON-объект с нужным порядком полей
          ObjectNode reorderedOffer = objectMapper.createObjectNode();
          reorderedOffer.put("market_sku", marketSku);
          reorderedOffer.put("offer_id", offer.get("offer_id").asText());
          reorderedOffer.put("price", offer.get("price").asInt());

          mergedOffers.add(reorderedOffer);

          // Ограничение количества market_sku
          if (mergedOffers.size() >= countOutMarkets) {
            break;
          }
        }
      }
      if (mergedOffers.size() >= countOutMarkets) {
        break;
      }
    }

    ObjectNode result = objectMapper.createObjectNode();
    result.set("offers", mergedOffers);
    System.out.println(objectMapper.writeValueAsString(result));
  }
}
