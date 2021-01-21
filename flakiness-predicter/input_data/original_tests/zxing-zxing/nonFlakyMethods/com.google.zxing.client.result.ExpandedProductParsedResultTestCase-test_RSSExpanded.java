@Test public void test_RSSExpanded(){
  Map<String,String> uncommonAIs=new HashMap<String,String>();
  uncommonAIs.put("123","544654");
  Result result=new Result("(01)66546(13)001205(3932)4455(3102)6544(123)544654",null,null,BarcodeFormat.RSS_EXPANDED);
  ExpandedProductParsedResult o=new ExpandedProductResultParser().parse(result);
  assertNotNull(o);
  assertEquals("66546",o.getProductID());
  assertNull(o.getSscc());
  assertNull(o.getLotNumber());
  assertNull(o.getProductionDate());
  assertEquals("001205",o.getPackagingDate());
  assertNull(o.getBestBeforeDate());
  assertNull(o.getExpirationDate());
  assertEquals("6544",o.getWeight());
  assertEquals("KG",o.getWeightType());
  assertEquals("2",o.getWeightIncrement());
  assertEquals("5",o.getPrice());
  assertEquals("2",o.getPriceIncrement());
  assertEquals("445",o.getPriceCurrency());
  assertEquals(uncommonAIs,o.getUncommonAIs());
}
