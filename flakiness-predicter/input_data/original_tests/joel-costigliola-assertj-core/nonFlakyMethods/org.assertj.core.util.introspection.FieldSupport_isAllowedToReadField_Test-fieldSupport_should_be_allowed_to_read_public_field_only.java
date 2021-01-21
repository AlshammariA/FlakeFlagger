@Test public void fieldSupport_should_be_allowed_to_read_public_field_only() throws Exception {
  boolean allowedToUsePrivateFields=fieldSupport.isAllowedToUsePrivateFields();
  fieldSupport.setAllowUsingPrivateFields(false);
  assertThat(fieldSupport.isAllowedToRead(Jedi.class.getField("lightSaberColor"))).isTrue();
  assertThat(fieldSupport.isAllowedToRead(Jedi.class.getDeclaredField("strangeNotReadablePrivateField"))).isFalse();
  fieldSupport.setAllowUsingPrivateFields(allowedToUsePrivateFields);
}
