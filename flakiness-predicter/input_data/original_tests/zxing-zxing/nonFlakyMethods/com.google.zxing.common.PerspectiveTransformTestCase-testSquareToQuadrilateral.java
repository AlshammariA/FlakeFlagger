@Test public void testSquareToQuadrilateral(){
  PerspectiveTransform pt=PerspectiveTransform.squareToQuadrilateral(2.0f,3.0f,10.0f,4.0f,16.0f,15.0f,4.0f,9.0f);
  assertPointEquals(2.0f,3.0f,0.0f,0.0f,pt);
  assertPointEquals(10.0f,4.0f,1.0f,0.0f,pt);
  assertPointEquals(4.0f,9.0f,0.0f,1.0f,pt);
  assertPointEquals(16.0f,15.0f,1.0f,1.0f,pt);
  assertPointEquals(6.535211f,6.8873234f,0.5f,0.5f,pt);
  assertPointEquals(48.0f,42.42857f,1.5f,1.5f,pt);
}
