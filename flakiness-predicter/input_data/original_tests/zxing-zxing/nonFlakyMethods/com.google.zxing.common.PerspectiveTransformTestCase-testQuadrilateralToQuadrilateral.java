@Test public void testQuadrilateralToQuadrilateral(){
  PerspectiveTransform pt=PerspectiveTransform.quadrilateralToQuadrilateral(2.0f,3.0f,10.0f,4.0f,16.0f,15.0f,4.0f,9.0f,103.0f,110.0f,300.0f,120.0f,290.0f,270.0f,150.0f,280.0f);
  assertPointEquals(103.0f,110.0f,2.0f,3.0f,pt);
  assertPointEquals(300.0f,120.0f,10.0f,4.0f,pt);
  assertPointEquals(290.0f,270.0f,16.0f,15.0f,pt);
  assertPointEquals(150.0f,280.0f,4.0f,9.0f,pt);
  assertPointEquals(7.1516876f,-64.60185f,0.5f,0.5f,pt);
  assertPointEquals(328.09116f,334.16385f,50.0f,50.0f,pt);
}
