@Test public void testConversions(){
  test(new Date());
  test(new Date(0l));
  test(new Date(1l));
  test(new Date(-1l));
  test(new Date(Long.MAX_VALUE));
  test(new Date(Long.MIN_VALUE));
  test(null);
}
