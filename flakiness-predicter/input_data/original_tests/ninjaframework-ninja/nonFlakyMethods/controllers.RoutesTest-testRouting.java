@Test public void testRouting(){
  startServerInProdMode();
  aRequestLike("GET","/").isHandledBy(ApplicationController.class,"index");
  aRequestLike("GET","/index").isHandledBy(ApplicationController.class,"index");
}
