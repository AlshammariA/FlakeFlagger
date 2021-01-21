@Test(expected=NumberFormatException.class) public void testAssignFromStringNumberFormatException(){
  PropertyState source=StringPropertyState.stringProperty("foo","bar");
  PropertyBuilder builder=PropertyBuilder.scalar(Type.LONG);
  builder.assignFrom(source);
}
