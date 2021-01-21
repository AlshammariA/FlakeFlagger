@Test public void testBasicPlaceholersAndParameters(){
  RouteBuilderImpl routeBuilder=new RouteBuilderImpl();
  routeBuilder.GET().route("/{name}/dashboard");
  Route route=buildRoute(routeBuilder);
  assertFalse(route.matches("GET","/dashboard"));
  assertTrue(route.matches("GET","/John/dashboard"));
  Map<String,String> map=route.getPathParametersEncoded("/John/dashboard");
  assertEquals(1,map.entrySet().size());
  assertEquals("John",map.get("name"));
  routeBuilder=new RouteBuilderImpl();
  routeBuilder.GET().route("/{name}/{id}/dashboard");
  route=buildRoute(routeBuilder);
  assertFalse(route.matches("GET","/dashboard"));
  assertTrue(route.matches("GET","/John/20/dashboard"));
  map=route.getPathParametersEncoded("/John/20/dashboard");
  assertEquals(2,map.entrySet().size());
  assertEquals("John",map.get("name"));
  assertEquals("20",map.get("id"));
}
