@Test public void should_fail_if_a_parameter_is_not_comparable(){
  thrown.expect(IllegalArgumentException.class);
  Rectangle r1=new Rectangle(10,20);
  Rectangle r2=new Rectangle(20,10);
  standardComparisonStrategy.isGreaterThanOrEqualTo(r1,r2);
}
