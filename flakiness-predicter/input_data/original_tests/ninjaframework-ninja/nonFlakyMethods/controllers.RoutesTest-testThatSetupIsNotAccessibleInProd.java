@Test public void testThatSetupIsNotAccessibleInProd(){
  startServerInProdMode();
  aRequestLike("GET","/setup").isNotHandledBy(ApplicationController.class,"setup");
}
