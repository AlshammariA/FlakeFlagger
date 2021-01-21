@Test public void testDateProperty(){
  PropertyBuilder builder=PropertyBuilder.array(Type.DATE);
  String date1="1970-01-01T00:00:00.000Z";
  String date2="1971-01-01T00:00:00.000Z";
  builder.setName("foo").addValue(date1).addValue(date2);
  Assert.assertEquals(MultiGenericPropertyState.dateProperty("foo",Arrays.asList(date1,date2)),builder.getPropertyState());
  builder.setScalar();
  try {
    builder.getPropertyState();
  }
 catch (  IllegalStateException expected) {
  }
  builder.removeValue(date1);
  Assert.assertEquals(GenericPropertyState.dateProperty("foo",date2),builder.getPropertyState());
}
