@Test public void fieldSupport_should_be_allowed_to_read_whatever_field_when_allowedToUsePrivateFields_flag_is_true() throws Exception {
  boolean allowedToUsePrivateFields=fieldSupport.isAllowedToUsePrivateFields();
  fieldSupport.setAllowUsingPrivateFields(true);
  assertThat(fieldSupport.isAllowedToRead(Jedi.class.getField("lightSaberColor"))).isTrue();
  assertThat(fieldSupport.isAllowedToRead(Jedi.class.getDeclaredField("strangeNotReadablePrivateField"))).isTrue();
  fieldSupport.setAllowUsingPrivateFields(allowedToUsePrivateFields);
}
