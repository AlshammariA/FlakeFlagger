@Test public void testConstructor(){
  Throwable cause=new Exception();
  new HttpException();
  new HttpException("Oppsie");
  new HttpException("Oppsie",cause);
  new ProtocolException();
  new ProtocolException("Oppsie");
  new ProtocolException("Oppsie",cause);
  new NoHttpResponseException("Oppsie");
  new ConnectionClosedException("Oppsie");
  new MethodNotSupportedException("Oppsie");
  new MethodNotSupportedException("Oppsie",cause);
  new UnsupportedHttpVersionException();
  new UnsupportedHttpVersionException("Oppsie");
}
