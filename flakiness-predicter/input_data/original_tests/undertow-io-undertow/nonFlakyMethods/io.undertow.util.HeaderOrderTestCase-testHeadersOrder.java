@Test public void testHeadersOrder() throws Exception {
  final Field orderIntField=HttpString.class.getDeclaredField("orderInt");
  orderIntField.setAccessible(true);
  Field[] fields=Headers.class.getDeclaredFields();
  final List<HttpString> headers=new ArrayList<HttpString>();
  for (  final Field field : fields) {
    Object value=field.get(null);
    if (!(value instanceof HttpString)) {
      continue;
    }
    HttpString header=(HttpString)value;
    if ((Integer)orderIntField.get(header) != 0) {
      headers.add(header);
    }
  }
  Collections.sort(headers,new Comparator<HttpString>(){
    @Override public int compare(    final HttpString o1,    final HttpString o2){
      return o1.toString().compareToIgnoreCase(o2.toString());
    }
  }
);
  int val=1;
  for (  final HttpString header : headers) {
    Assert.assertEquals(val++,orderIntField.get(header));
  }
}
