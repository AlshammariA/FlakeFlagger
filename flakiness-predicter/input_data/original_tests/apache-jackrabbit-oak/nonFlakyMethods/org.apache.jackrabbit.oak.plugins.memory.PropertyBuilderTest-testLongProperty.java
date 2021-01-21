@Test public void testLongProperty(){
  PropertyBuilder builder=PropertyBuilder.scalar(Type.LONG);
  builder.setName("foo").setValue(42L);
  Assert.assertEquals(LongPropertyState.createLongProperty("foo",42L),builder.getPropertyState());
  builder.setArray();
  Assert.assertEquals(MultiLongPropertyState.createLongProperty("foo",Arrays.asList(42L)),builder.getPropertyState());
}
