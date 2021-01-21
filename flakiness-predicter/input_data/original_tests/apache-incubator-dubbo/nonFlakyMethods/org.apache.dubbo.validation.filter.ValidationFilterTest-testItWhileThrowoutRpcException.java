@Test(expected=RpcException.class) public void testItWhileThrowoutRpcException() throws Exception {
  URL url=URL.valueOf("test://test:11/test?default.validation=true");
  given(validation.getValidator(url)).willThrow(new RpcException("rpc exception"));
  given(invoker.invoke(invocation)).willReturn(new RpcResult("success"));
  given(invoker.getUrl()).willReturn(url);
  given(invocation.getMethodName()).willReturn("echo1");
  given(invocation.getParameterTypes()).willReturn(new Class<?>[]{String.class});
  given(invocation.getArguments()).willReturn(new Object[]{"arg1"});
  validationFilter.setValidation(validation);
  validationFilter.invoke(invoker,invocation);
}
