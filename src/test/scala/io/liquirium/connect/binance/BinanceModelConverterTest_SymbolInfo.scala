package io.liquirium.connect.binance

import io.liquirium.connect.binance.helpers.BinanceTestHelpers.symbolInfo
import io.liquirium.core.helpers.CoreHelpers.dec
import io.liquirium.core.{OrderQuantityPrecision, PricePrecision}

class BinanceModelConverterTest_SymbolInfo extends BinanceModelConverterTest {

  private def convert(si: BinanceSymbolInfo) = converter().convertSymbolInfo(si)

  test("the tick size is set as the price precision") {
    convert(symbolInfo(tickSize = dec("0.001"))).pricePrecision shouldEqual
      PricePrecision.MultipleOf.apply(step = dec("0.001"))
  }

  test("the step size is set as the order quantity precision") {
    convert(symbolInfo(stepSize = dec("0.0001"))).orderQuantityPrecision shouldEqual
      OrderQuantityPrecision.MultipleOf(dec("0.0001"))
  }

}
