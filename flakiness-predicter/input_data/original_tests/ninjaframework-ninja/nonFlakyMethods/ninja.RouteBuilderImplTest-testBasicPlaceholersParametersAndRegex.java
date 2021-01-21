@Test public void testBasicPlaceholersParametersAndRegex(){
  RouteBuilderImpl routeBuilder=new RouteBuilderImpl();
  routeBuilder.GET().route("/John/{id}/.*");
  Route route=buildRoute(routeBuilder);
  assertTrue(route.matches("GET","/John/20/dashboard"));
  Map<String,String> map=route.getPathParametersEncoded("/John/20/dashboard");
  assertEquals(1,map.entrySet().size());
  assertEquals("20",map.get("id"));
  assertTrue(route.matches("GET","/John/20/admin"));
  map=route.getPathParametersEncoded("/John/20/admin");
  assertEquals(1,map.entrySet().size());
  assertEquals("20",map.get("id"));
  assertTrue(route.matches("GET","/John/20/mock"));
  map=route.getPathParametersEncoded("/John/20/mock");
  assertEquals(1,map.entrySet().size());
  assertEquals("20",map.get("id"));
}
