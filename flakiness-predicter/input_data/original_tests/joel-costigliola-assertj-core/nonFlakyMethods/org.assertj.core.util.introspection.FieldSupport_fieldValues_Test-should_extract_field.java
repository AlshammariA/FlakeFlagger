@Test public void should_extract_field(){
  Long id=fieldSupport.fieldValue("id",Long.class,yoda);
  assertThat(id).isEqualTo(1L);
  Object idObject=fieldSupport.fieldValue("id",Object.class,yoda);
  assertThat(idObject).isInstanceOf(Long.class).isEqualTo(1L);
}
