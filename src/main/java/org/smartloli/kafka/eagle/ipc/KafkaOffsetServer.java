/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.smartloli.kafka.eagle.ipc;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Kafka offset rpc api.
 * 
 * @author smartloli.
 *
 *         Created by Jan 3, 2017
 */
public class KafkaOffsetServer {

	public interface Iface {

		public String query(String group, String topic, int partition) throws org.apache.thrift.TException;

		public String getOffset() throws org.apache.thrift.TException;

		public String sql(String sql) throws org.apache.thrift.TException;

		public String getConsumer() throws org.apache.thrift.TException;

		public String getConsumerPage(String search, int iDisplayStart, int iDisplayLength) throws org.apache.thrift.TException;

		public String getActiverConsumer() throws org.apache.thrift.TException;

	}

	public interface AsyncIface {

		public void query(String group, String topic, int partition, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

		public void getOffset(org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

		public void sql(String sql, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

		public void getConsumer(org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

		public void getConsumerPage(String search, int iDisplayStart, int iDisplayLength, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

		public void getActiverConsumer(org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException;

	}

	public static class Client extends org.apache.thrift.TServiceClient implements Iface {
		public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
			public Factory() {
			}

			public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
				return new Client(prot);
			}

			public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
				return new Client(iprot, oprot);
			}
		}

		public Client(org.apache.thrift.protocol.TProtocol prot) {
			super(prot, prot);
		}

		public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
			super(iprot, oprot);
		}

		public String query(String group, String topic, int partition) throws org.apache.thrift.TException {
			send_query(group, topic, partition);
			return recv_query();
		}

		public void send_query(String group, String topic, int partition) throws org.apache.thrift.TException {
			query_args args = new query_args();
			args.setGroup(group);
			args.setTopic(topic);
			args.setPartition(partition);
			sendBase("query", args);
		}

		public String recv_query() throws org.apache.thrift.TException {
			query_result result = new query_result();
			receiveBase(result, "query");
			if (result.isSetSuccess()) {
				return result.success;
			}
			throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "query failed: unknown result");
		}

		public String getOffset() throws org.apache.thrift.TException {
			send_getOffset();
			return recv_getOffset();
		}

		public void send_getOffset() throws org.apache.thrift.TException {
			getOffset_args args = new getOffset_args();
			sendBase("getOffset", args);
		}

		public String recv_getOffset() throws org.apache.thrift.TException {
			getOffset_result result = new getOffset_result();
			receiveBase(result, "getOffset");
			if (result.isSetSuccess()) {
				return result.success;
			}
			throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getOffset failed: unknown result");
		}

		public String sql(String sql) throws org.apache.thrift.TException {
			send_sql(sql);
			return recv_sql();
		}

		public void send_sql(String sql) throws org.apache.thrift.TException {
			sql_args args = new sql_args();
			args.setSql(sql);
			sendBase("sql", args);
		}

		public String recv_sql() throws org.apache.thrift.TException {
			sql_result result = new sql_result();
			receiveBase(result, "sql");
			if (result.isSetSuccess()) {
				return result.success;
			}
			throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "sql failed: unknown result");
		}

		public String getConsumer() throws org.apache.thrift.TException {
			send_getConsumer();
			return recv_getConsumer();
		}

		public void send_getConsumer() throws org.apache.thrift.TException {
			getConsumer_args args = new getConsumer_args();
			sendBase("getConsumer", args);
		}

		public String recv_getConsumer() throws org.apache.thrift.TException {
			getConsumer_result result = new getConsumer_result();
			receiveBase(result, "getConsumer");
			if (result.isSetSuccess()) {
				return result.success;
			}
			throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getConsumer failed: unknown result");
		}

		public String getConsumerPage(String search, int iDisplayStart, int iDisplayLength) throws org.apache.thrift.TException {
			send_getConsumerPage(search, iDisplayStart, iDisplayLength);
			return recv_getConsumerPage();
		}

		public void send_getConsumerPage(String search, int iDisplayStart, int iDisplayLength) throws org.apache.thrift.TException {
			getConsumerPage_args args = new getConsumerPage_args();
			args.setSearch(search);
			args.setIDisplayStart(iDisplayStart);
			args.setIDisplayLength(iDisplayLength);
			sendBase("getConsumerPage", args);
		}

		public String recv_getConsumerPage() throws org.apache.thrift.TException {
			getConsumerPage_result result = new getConsumerPage_result();
			receiveBase(result, "getConsumerPage");
			if (result.isSetSuccess()) {
				return result.success;
			}
			throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getConsumerPage failed: unknown result");
		}

		public String getActiverConsumer() throws org.apache.thrift.TException {
			send_getActiverConsumer();
			return recv_getActiverConsumer();
		}

		public void send_getActiverConsumer() throws org.apache.thrift.TException {
			getActiverConsumer_args args = new getActiverConsumer_args();
			sendBase("getActiverConsumer", args);
		}

		public String recv_getActiverConsumer() throws org.apache.thrift.TException {
			getActiverConsumer_result result = new getActiverConsumer_result();
			receiveBase(result, "getActiverConsumer");
			if (result.isSetSuccess()) {
				return result.success;
			}
			throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getActiverConsumer failed: unknown result");
		}

	}

	public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
		public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
			private org.apache.thrift.async.TAsyncClientManager clientManager;
			private org.apache.thrift.protocol.TProtocolFactory protocolFactory;

			public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
				this.clientManager = clientManager;
				this.protocolFactory = protocolFactory;
			}

			public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
				return new AsyncClient(protocolFactory, clientManager, transport);
			}
		}

		public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
			super(protocolFactory, clientManager, transport);
		}

		public void query(String group, String topic, int partition, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
			checkReady();
			query_call method_call = new query_call(group, topic, partition, resultHandler, this, ___protocolFactory, ___transport);
			this.___currentMethod = method_call;
			___manager.call(method_call);
		}

		public static class query_call extends org.apache.thrift.async.TAsyncMethodCall {
			private String group;
			private String topic;
			private int partition;

			public query_call(String group, String topic, int partition, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory,
					org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
				super(client, protocolFactory, transport, resultHandler, false);
				this.group = group;
				this.topic = topic;
				this.partition = partition;
			}

			public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
				prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("query", org.apache.thrift.protocol.TMessageType.CALL, 0));
				query_args args = new query_args();
				args.setGroup(group);
				args.setTopic(topic);
				args.setPartition(partition);
				args.write(prot);
				prot.writeMessageEnd();
			}

			public String getResult() throws org.apache.thrift.TException {
				if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
					throw new IllegalStateException("Method call not finished!");
				}
				org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
				org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
				return (new Client(prot)).recv_query();
			}
		}

		public void getOffset(org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
			checkReady();
			getOffset_call method_call = new getOffset_call(resultHandler, this, ___protocolFactory, ___transport);
			this.___currentMethod = method_call;
			___manager.call(method_call);
		}

		public static class getOffset_call extends org.apache.thrift.async.TAsyncMethodCall {
			public getOffset_call(org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory,
					org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
				super(client, protocolFactory, transport, resultHandler, false);
			}

			public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
				prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getOffset", org.apache.thrift.protocol.TMessageType.CALL, 0));
				getOffset_args args = new getOffset_args();
				args.write(prot);
				prot.writeMessageEnd();
			}

			public String getResult() throws org.apache.thrift.TException {
				if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
					throw new IllegalStateException("Method call not finished!");
				}
				org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
				org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
				return (new Client(prot)).recv_getOffset();
			}
		}

		public void sql(String sql, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
			checkReady();
			sql_call method_call = new sql_call(sql, resultHandler, this, ___protocolFactory, ___transport);
			this.___currentMethod = method_call;
			___manager.call(method_call);
		}

		public static class sql_call extends org.apache.thrift.async.TAsyncMethodCall {
			private String sql;

			public sql_call(String sql, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory,
					org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
				super(client, protocolFactory, transport, resultHandler, false);
				this.sql = sql;
			}

			public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
				prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("sql", org.apache.thrift.protocol.TMessageType.CALL, 0));
				sql_args args = new sql_args();
				args.setSql(sql);
				args.write(prot);
				prot.writeMessageEnd();
			}

			public String getResult() throws org.apache.thrift.TException {
				if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
					throw new IllegalStateException("Method call not finished!");
				}
				org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
				org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
				return (new Client(prot)).recv_sql();
			}
		}

		public void getConsumer(org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
			checkReady();
			getConsumer_call method_call = new getConsumer_call(resultHandler, this, ___protocolFactory, ___transport);
			this.___currentMethod = method_call;
			___manager.call(method_call);
		}

		public static class getConsumer_call extends org.apache.thrift.async.TAsyncMethodCall {
			public getConsumer_call(org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory,
					org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
				super(client, protocolFactory, transport, resultHandler, false);
			}

			public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
				prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getConsumer", org.apache.thrift.protocol.TMessageType.CALL, 0));
				getConsumer_args args = new getConsumer_args();
				args.write(prot);
				prot.writeMessageEnd();
			}

			public String getResult() throws org.apache.thrift.TException {
				if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
					throw new IllegalStateException("Method call not finished!");
				}
				org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
				org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
				return (new Client(prot)).recv_getConsumer();
			}
		}

		public void getConsumerPage(String search, int iDisplayStart, int iDisplayLength, org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
			checkReady();
			getConsumerPage_call method_call = new getConsumerPage_call(search, iDisplayStart, iDisplayLength, resultHandler, this, ___protocolFactory, ___transport);
			this.___currentMethod = method_call;
			___manager.call(method_call);
		}

		public static class getConsumerPage_call extends org.apache.thrift.async.TAsyncMethodCall {
			private String search;
			private int iDisplayStart;
			private int iDisplayLength;

			public getConsumerPage_call(String search, int iDisplayStart, int iDisplayLength, org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client,
					org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
				super(client, protocolFactory, transport, resultHandler, false);
				this.search = search;
				this.iDisplayStart = iDisplayStart;
				this.iDisplayLength = iDisplayLength;
			}

			public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
				prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getConsumerPage", org.apache.thrift.protocol.TMessageType.CALL, 0));
				getConsumerPage_args args = new getConsumerPage_args();
				args.setSearch(search);
				args.setIDisplayStart(iDisplayStart);
				args.setIDisplayLength(iDisplayLength);
				args.write(prot);
				prot.writeMessageEnd();
			}

			public String getResult() throws org.apache.thrift.TException {
				if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
					throw new IllegalStateException("Method call not finished!");
				}
				org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
				org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
				return (new Client(prot)).recv_getConsumerPage();
			}
		}

		public void getActiverConsumer(org.apache.thrift.async.AsyncMethodCallback resultHandler) throws org.apache.thrift.TException {
			checkReady();
			getActiverConsumer_call method_call = new getActiverConsumer_call(resultHandler, this, ___protocolFactory, ___transport);
			this.___currentMethod = method_call;
			___manager.call(method_call);
		}

		public static class getActiverConsumer_call extends org.apache.thrift.async.TAsyncMethodCall {
			public getActiverConsumer_call(org.apache.thrift.async.AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory,
					org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
				super(client, protocolFactory, transport, resultHandler, false);
			}

			public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
				prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getActiverConsumer", org.apache.thrift.protocol.TMessageType.CALL, 0));
				getActiverConsumer_args args = new getActiverConsumer_args();
				args.write(prot);
				prot.writeMessageEnd();
			}

			public String getResult() throws org.apache.thrift.TException {
				if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
					throw new IllegalStateException("Method call not finished!");
				}
				org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
				org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
				return (new Client(prot)).recv_getActiverConsumer();
			}
		}

	}

	public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
		@SuppressWarnings("unused")
		private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());

		public Processor(I iface) {
			super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
		}

		protected Processor(I iface, Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
			super(iface, getProcessMap(processMap));
		}

		private static <I extends Iface> Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> getProcessMap(Map<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
			processMap.put("query", new query());
			processMap.put("getOffset", new getOffset());
			processMap.put("sql", new sql());
			processMap.put("getConsumer", new getConsumer());
			processMap.put("getConsumerPage", new getConsumerPage());
			processMap.put("getActiverConsumer", new getActiverConsumer());
			return processMap;
		}

		public static class query<I extends Iface> extends org.apache.thrift.ProcessFunction<I, query_args> {
			public query() {
				super("query");
			}

			public query_args getEmptyArgsInstance() {
				return new query_args();
			}

			protected boolean isOneway() {
				return false;
			}

			public query_result getResult(I iface, query_args args) throws org.apache.thrift.TException {
				query_result result = new query_result();
				result.success = iface.query(args.group, args.topic, args.partition);
				return result;
			}
		}

		public static class getOffset<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getOffset_args> {
			public getOffset() {
				super("getOffset");
			}

			public getOffset_args getEmptyArgsInstance() {
				return new getOffset_args();
			}

			protected boolean isOneway() {
				return false;
			}

			public getOffset_result getResult(I iface, getOffset_args args) throws org.apache.thrift.TException {
				getOffset_result result = new getOffset_result();
				result.success = iface.getOffset();
				return result;
			}
		}

		public static class sql<I extends Iface> extends org.apache.thrift.ProcessFunction<I, sql_args> {
			public sql() {
				super("sql");
			}

			public sql_args getEmptyArgsInstance() {
				return new sql_args();
			}

			protected boolean isOneway() {
				return false;
			}

			public sql_result getResult(I iface, sql_args args) throws org.apache.thrift.TException {
				sql_result result = new sql_result();
				result.success = iface.sql(args.sql);
				return result;
			}
		}

		public static class getConsumer<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getConsumer_args> {
			public getConsumer() {
				super("getConsumer");
			}

			public getConsumer_args getEmptyArgsInstance() {
				return new getConsumer_args();
			}

			protected boolean isOneway() {
				return false;
			}

			public getConsumer_result getResult(I iface, getConsumer_args args) throws org.apache.thrift.TException {
				getConsumer_result result = new getConsumer_result();
				result.success = iface.getConsumer();
				return result;
			}
		}

		public static class getConsumerPage<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getConsumerPage_args> {
			public getConsumerPage() {
				super("getConsumerPage");
			}

			public getConsumerPage_args getEmptyArgsInstance() {
				return new getConsumerPage_args();
			}

			protected boolean isOneway() {
				return false;
			}

			public getConsumerPage_result getResult(I iface, getConsumerPage_args args) throws org.apache.thrift.TException {
				getConsumerPage_result result = new getConsumerPage_result();
				result.success = iface.getConsumerPage(args.search, args.iDisplayStart, args.iDisplayLength);
				return result;
			}
		}

		public static class getActiverConsumer<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getActiverConsumer_args> {
			public getActiverConsumer() {
				super("getActiverConsumer");
			}

			public getActiverConsumer_args getEmptyArgsInstance() {
				return new getActiverConsumer_args();
			}

			protected boolean isOneway() {
				return false;
			}

			public getActiverConsumer_result getResult(I iface, getActiverConsumer_args args) throws org.apache.thrift.TException {
				getActiverConsumer_result result = new getActiverConsumer_result();
				result.success = iface.getActiverConsumer();
				return result;
			}
		}

	}

	public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
		private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());

		public AsyncProcessor(I iface) {
			super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
		}

		protected AsyncProcessor(I iface, Map<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>> processMap) {
			super(iface, getProcessMap(processMap));
		}

		private static <I extends AsyncIface> Map<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>> getProcessMap(
				Map<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>> processMap) {
			processMap.put("query", new query());
			processMap.put("getOffset", new getOffset());
			processMap.put("sql", new sql());
			processMap.put("getConsumer", new getConsumer());
			processMap.put("getConsumerPage", new getConsumerPage());
			processMap.put("getActiverConsumer", new getActiverConsumer());
			return processMap;
		}

		public static class query<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, query_args, String> {
			public query() {
				super("query");
			}

			public query_args getEmptyArgsInstance() {
				return new query_args();
			}

			public AsyncMethodCallback<String> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
				final org.apache.thrift.AsyncProcessFunction fcall = this;
				return new AsyncMethodCallback<String>() {
					public void onComplete(String o) {
						query_result result = new query_result();
						result.success = o;
						try {
							fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
							return;
						} catch (Exception e) {
							LOGGER.error("Exception writing to internal frame buffer", e);
						}
						fb.close();
					}

					@SuppressWarnings("unused")
					public void onError(Exception e) {
						byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
						org.apache.thrift.TBase msg;
						query_result result = new query_result();
						{
							msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
							msg = (org.apache.thrift.TBase) new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
						}
						try {
							fcall.sendResponse(fb, msg, msgType, seqid);
							return;
						} catch (Exception ex) {
							LOGGER.error("Exception writing to internal frame buffer", ex);
						}
						fb.close();
					}
				};
			}

			protected boolean isOneway() {
				return false;
			}

			public void start(I iface, query_args args, org.apache.thrift.async.AsyncMethodCallback<String> resultHandler) throws TException {
				iface.query(args.group, args.topic, args.partition, resultHandler);
			}
		}

		public static class getOffset<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, getOffset_args, String> {
			public getOffset() {
				super("getOffset");
			}

			public getOffset_args getEmptyArgsInstance() {
				return new getOffset_args();
			}

			public AsyncMethodCallback<String> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
				final org.apache.thrift.AsyncProcessFunction fcall = this;
				return new AsyncMethodCallback<String>() {
					public void onComplete(String o) {
						getOffset_result result = new getOffset_result();
						result.success = o;
						try {
							fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
							return;
						} catch (Exception e) {
							LOGGER.error("Exception writing to internal frame buffer", e);
						}
						fb.close();
					}

					@SuppressWarnings("unused")
					public void onError(Exception e) {
						byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
						org.apache.thrift.TBase msg;
						getOffset_result result = new getOffset_result();
						{
							msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
							msg = (org.apache.thrift.TBase) new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
						}
						try {
							fcall.sendResponse(fb, msg, msgType, seqid);
							return;
						} catch (Exception ex) {
							LOGGER.error("Exception writing to internal frame buffer", ex);
						}
						fb.close();
					}
				};
			}

			protected boolean isOneway() {
				return false;
			}

			public void start(I iface, getOffset_args args, org.apache.thrift.async.AsyncMethodCallback<String> resultHandler) throws TException {
				iface.getOffset(resultHandler);
			}
		}

		public static class sql<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, sql_args, String> {
			public sql() {
				super("sql");
			}

			public sql_args getEmptyArgsInstance() {
				return new sql_args();
			}

			public AsyncMethodCallback<String> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
				final org.apache.thrift.AsyncProcessFunction fcall = this;
				return new AsyncMethodCallback<String>() {
					public void onComplete(String o) {
						sql_result result = new sql_result();
						result.success = o;
						try {
							fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
							return;
						} catch (Exception e) {
							LOGGER.error("Exception writing to internal frame buffer", e);
						}
						fb.close();
					}

					@SuppressWarnings("unused")
					public void onError(Exception e) {
						byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
						org.apache.thrift.TBase msg;
						sql_result result = new sql_result();
						{
							msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
							msg = (org.apache.thrift.TBase) new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
						}
						try {
							fcall.sendResponse(fb, msg, msgType, seqid);
							return;
						} catch (Exception ex) {
							LOGGER.error("Exception writing to internal frame buffer", ex);
						}
						fb.close();
					}
				};
			}

			protected boolean isOneway() {
				return false;
			}

			public void start(I iface, sql_args args, org.apache.thrift.async.AsyncMethodCallback<String> resultHandler) throws TException {
				iface.sql(args.sql, resultHandler);
			}
		}

		public static class getConsumer<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, getConsumer_args, String> {
			public getConsumer() {
				super("getConsumer");
			}

			public getConsumer_args getEmptyArgsInstance() {
				return new getConsumer_args();
			}

			public AsyncMethodCallback<String> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
				final org.apache.thrift.AsyncProcessFunction fcall = this;
				return new AsyncMethodCallback<String>() {
					public void onComplete(String o) {
						getConsumer_result result = new getConsumer_result();
						result.success = o;
						try {
							fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
							return;
						} catch (Exception e) {
							LOGGER.error("Exception writing to internal frame buffer", e);
						}
						fb.close();
					}

					@SuppressWarnings("unused")
					public void onError(Exception e) {
						byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
						org.apache.thrift.TBase msg;
						getConsumer_result result = new getConsumer_result();
						{
							msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
							msg = (org.apache.thrift.TBase) new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
						}
						try {
							fcall.sendResponse(fb, msg, msgType, seqid);
							return;
						} catch (Exception ex) {
							LOGGER.error("Exception writing to internal frame buffer", ex);
						}
						fb.close();
					}
				};
			}

			protected boolean isOneway() {
				return false;
			}

			public void start(I iface, getConsumer_args args, org.apache.thrift.async.AsyncMethodCallback<String> resultHandler) throws TException {
				iface.getConsumer(resultHandler);
			}
		}

		public static class getConsumerPage<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, getConsumerPage_args, String> {
			public getConsumerPage() {
				super("getConsumerPage");
			}

			public getConsumerPage_args getEmptyArgsInstance() {
				return new getConsumerPage_args();
			}

			public AsyncMethodCallback<String> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
				final org.apache.thrift.AsyncProcessFunction fcall = this;
				return new AsyncMethodCallback<String>() {
					public void onComplete(String o) {
						getConsumerPage_result result = new getConsumerPage_result();
						result.success = o;
						try {
							fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
							return;
						} catch (Exception e) {
							LOGGER.error("Exception writing to internal frame buffer", e);
						}
						fb.close();
					}

					@SuppressWarnings("unused")
					public void onError(Exception e) {
						byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
						org.apache.thrift.TBase msg;
						getConsumerPage_result result = new getConsumerPage_result();
						{
							msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
							msg = (org.apache.thrift.TBase) new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
						}
						try {
							fcall.sendResponse(fb, msg, msgType, seqid);
							return;
						} catch (Exception ex) {
							LOGGER.error("Exception writing to internal frame buffer", ex);
						}
						fb.close();
					}
				};
			}

			protected boolean isOneway() {
				return false;
			}

			public void start(I iface, getConsumerPage_args args, org.apache.thrift.async.AsyncMethodCallback<String> resultHandler) throws TException {
				iface.getConsumerPage(args.search, args.iDisplayStart, args.iDisplayLength, resultHandler);
			}
		}

		public static class getActiverConsumer<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, getActiverConsumer_args, String> {
			public getActiverConsumer() {
				super("getActiverConsumer");
			}

			public getActiverConsumer_args getEmptyArgsInstance() {
				return new getActiverConsumer_args();
			}

			public AsyncMethodCallback<String> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
				final org.apache.thrift.AsyncProcessFunction fcall = this;
				return new AsyncMethodCallback<String>() {
					public void onComplete(String o) {
						getActiverConsumer_result result = new getActiverConsumer_result();
						result.success = o;
						try {
							fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY, seqid);
							return;
						} catch (Exception e) {
							LOGGER.error("Exception writing to internal frame buffer", e);
						}
						fb.close();
					}

					@SuppressWarnings("unused")
					public void onError(Exception e) {
						byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
						org.apache.thrift.TBase msg;
						getActiverConsumer_result result = new getActiverConsumer_result();
						{
							msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
							msg = (org.apache.thrift.TBase) new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
						}
						try {
							fcall.sendResponse(fb, msg, msgType, seqid);
							return;
						} catch (Exception ex) {
							LOGGER.error("Exception writing to internal frame buffer", ex);
						}
						fb.close();
					}
				};
			}

			protected boolean isOneway() {
				return false;
			}

			public void start(I iface, getActiverConsumer_args args, org.apache.thrift.async.AsyncMethodCallback<String> resultHandler) throws TException {
				iface.getActiverConsumer(resultHandler);
			}
		}

	}

	@SuppressWarnings("serial")
	public static class query_args implements org.apache.thrift.TBase<query_args, query_args._Fields>, java.io.Serializable, Cloneable, Comparable<query_args> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("query_args");

		private static final org.apache.thrift.protocol.TField GROUP_FIELD_DESC = new org.apache.thrift.protocol.TField("group", org.apache.thrift.protocol.TType.STRING, (short) 1);
		private static final org.apache.thrift.protocol.TField TOPIC_FIELD_DESC = new org.apache.thrift.protocol.TField("topic", org.apache.thrift.protocol.TType.STRING, (short) 2);
		private static final org.apache.thrift.protocol.TField PARTITION_FIELD_DESC = new org.apache.thrift.protocol.TField("partition", org.apache.thrift.protocol.TType.I32, (short) 3);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new query_argsStandardSchemeFactory());
			schemes.put(TupleScheme.class, new query_argsTupleSchemeFactory());
		}

		public String group; // required
		public String topic; // required
		public int partition; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			GROUP((short) 1, "group"), TOPIC((short) 2, "topic"), PARTITION((short) 3, "partition");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 1: // GROUP
					return GROUP;
				case 2: // TOPIC
					return TOPIC;
				case 3: // PARTITION
					return PARTITION;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		private static final int __PARTITION_ISSET_ID = 0;
		private byte __isset_bitfield = 0;
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.GROUP, new org.apache.thrift.meta_data.FieldMetaData("group", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			tmpMap.put(_Fields.TOPIC, new org.apache.thrift.meta_data.FieldMetaData("topic", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			tmpMap.put(_Fields.PARTITION,
					new org.apache.thrift.meta_data.FieldMetaData("partition", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(query_args.class, metaDataMap);
		}

		public query_args() {
		}

		public query_args(String group, String topic, int partition) {
			this();
			this.group = group;
			this.topic = topic;
			this.partition = partition;
			setPartitionIsSet(true);
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public query_args(query_args other) {
			__isset_bitfield = other.__isset_bitfield;
			if (other.isSetGroup()) {
				this.group = other.group;
			}
			if (other.isSetTopic()) {
				this.topic = other.topic;
			}
			this.partition = other.partition;
		}

		public query_args deepCopy() {
			return new query_args(this);
		}

		@Override
		public void clear() {
			this.group = null;
			this.topic = null;
			setPartitionIsSet(false);
			this.partition = 0;
		}

		public String getGroup() {
			return this.group;
		}

		public query_args setGroup(String group) {
			this.group = group;
			return this;
		}

		public void unsetGroup() {
			this.group = null;
		}

		/**
		 * Returns true if field group is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetGroup() {
			return this.group != null;
		}

		public void setGroupIsSet(boolean value) {
			if (!value) {
				this.group = null;
			}
		}

		public String getTopic() {
			return this.topic;
		}

		public query_args setTopic(String topic) {
			this.topic = topic;
			return this;
		}

		public void unsetTopic() {
			this.topic = null;
		}

		/**
		 * Returns true if field topic is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetTopic() {
			return this.topic != null;
		}

		public void setTopicIsSet(boolean value) {
			if (!value) {
				this.topic = null;
			}
		}

		public int getPartition() {
			return this.partition;
		}

		public query_args setPartition(int partition) {
			this.partition = partition;
			setPartitionIsSet(true);
			return this;
		}

		public void unsetPartition() {
			__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PARTITION_ISSET_ID);
		}

		/**
		 * Returns true if field partition is set (has been assigned a value)
		 * and false otherwise
		 */
		public boolean isSetPartition() {
			return EncodingUtils.testBit(__isset_bitfield, __PARTITION_ISSET_ID);
		}

		public void setPartitionIsSet(boolean value) {
			__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PARTITION_ISSET_ID, value);
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case GROUP:
				if (value == null) {
					unsetGroup();
				} else {
					setGroup((String) value);
				}
				break;

			case TOPIC:
				if (value == null) {
					unsetTopic();
				} else {
					setTopic((String) value);
				}
				break;

			case PARTITION:
				if (value == null) {
					unsetPartition();
				} else {
					setPartition((Integer) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case GROUP:
				return getGroup();

			case TOPIC:
				return getTopic();

			case PARTITION:
				return Integer.valueOf(getPartition());

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case GROUP:
				return isSetGroup();
			case TOPIC:
				return isSetTopic();
			case PARTITION:
				return isSetPartition();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof query_args)
				return this.equals((query_args) that);
			return false;
		}

		public boolean equals(query_args that) {
			if (that == null)
				return false;

			boolean this_present_group = true && this.isSetGroup();
			boolean that_present_group = true && that.isSetGroup();
			if (this_present_group || that_present_group) {
				if (!(this_present_group && that_present_group))
					return false;
				if (!this.group.equals(that.group))
					return false;
			}

			boolean this_present_topic = true && this.isSetTopic();
			boolean that_present_topic = true && that.isSetTopic();
			if (this_present_topic || that_present_topic) {
				if (!(this_present_topic && that_present_topic))
					return false;
				if (!this.topic.equals(that.topic))
					return false;
			}

			boolean this_present_partition = true;
			boolean that_present_partition = true;
			if (this_present_partition || that_present_partition) {
				if (!(this_present_partition && that_present_partition))
					return false;
				if (this.partition != that.partition)
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(query_args other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetGroup()).compareTo(other.isSetGroup());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetGroup()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.group, other.group);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			lastComparison = Boolean.valueOf(isSetTopic()).compareTo(other.isSetTopic());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetTopic()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.topic, other.topic);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			lastComparison = Boolean.valueOf(isSetPartition()).compareTo(other.isSetPartition());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetPartition()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.partition, other.partition);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("query_args(");
			boolean first = true;

			sb.append("group:");
			if (this.group == null) {
				sb.append("null");
			} else {
				sb.append(this.group);
			}
			first = false;
			if (!first)
				sb.append(", ");
			sb.append("topic:");
			if (this.topic == null) {
				sb.append("null");
			} else {
				sb.append(this.topic);
			}
			first = false;
			if (!first)
				sb.append(", ");
			sb.append("partition:");
			sb.append(this.partition);
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				// it doesn't seem like you should have to do this, but java
				// serialization is wacky, and doesn't call the default
				// constructor.
				__isset_bitfield = 0;
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class query_argsStandardSchemeFactory implements SchemeFactory {
			public query_argsStandardScheme getScheme() {
				return new query_argsStandardScheme();
			}
		}

		private static class query_argsStandardScheme extends StandardScheme<query_args> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, query_args struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 1: // GROUP
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.group = iprot.readString();
							struct.setGroupIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 2: // TOPIC
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.topic = iprot.readString();
							struct.setTopicIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 3: // PARTITION
						if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
							struct.partition = iprot.readI32();
							struct.setPartitionIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, query_args struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.group != null) {
					oprot.writeFieldBegin(GROUP_FIELD_DESC);
					oprot.writeString(struct.group);
					oprot.writeFieldEnd();
				}
				if (struct.topic != null) {
					oprot.writeFieldBegin(TOPIC_FIELD_DESC);
					oprot.writeString(struct.topic);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldBegin(PARTITION_FIELD_DESC);
				oprot.writeI32(struct.partition);
				oprot.writeFieldEnd();
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class query_argsTupleSchemeFactory implements SchemeFactory {
			public query_argsTupleScheme getScheme() {
				return new query_argsTupleScheme();
			}
		}

		private static class query_argsTupleScheme extends TupleScheme<query_args> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, query_args struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetGroup()) {
					optionals.set(0);
				}
				if (struct.isSetTopic()) {
					optionals.set(1);
				}
				if (struct.isSetPartition()) {
					optionals.set(2);
				}
				oprot.writeBitSet(optionals, 3);
				if (struct.isSetGroup()) {
					oprot.writeString(struct.group);
				}
				if (struct.isSetTopic()) {
					oprot.writeString(struct.topic);
				}
				if (struct.isSetPartition()) {
					oprot.writeI32(struct.partition);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, query_args struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(3);
				if (incoming.get(0)) {
					struct.group = iprot.readString();
					struct.setGroupIsSet(true);
				}
				if (incoming.get(1)) {
					struct.topic = iprot.readString();
					struct.setTopicIsSet(true);
				}
				if (incoming.get(2)) {
					struct.partition = iprot.readI32();
					struct.setPartitionIsSet(true);
				}
			}
		}

	}

	@SuppressWarnings("serial")
	public static class query_result implements org.apache.thrift.TBase<query_result, query_result._Fields>, java.io.Serializable, Cloneable, Comparable<query_result> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("query_result");

		private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short) 0);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new query_resultStandardSchemeFactory());
			schemes.put(TupleScheme.class, new query_resultTupleSchemeFactory());
		}

		public String success; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SUCCESS((short) 0, "success");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 0: // SUCCESS
					return SUCCESS;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(query_result.class, metaDataMap);
		}

		public query_result() {
		}

		public query_result(String success) {
			this();
			this.success = success;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public query_result(query_result other) {
			if (other.isSetSuccess()) {
				this.success = other.success;
			}
		}

		public query_result deepCopy() {
			return new query_result(this);
		}

		@Override
		public void clear() {
			this.success = null;
		}

		public String getSuccess() {
			return this.success;
		}

		public query_result setSuccess(String success) {
			this.success = success;
			return this;
		}

		public void unsetSuccess() {
			this.success = null;
		}

		/**
		 * Returns true if field success is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSuccess() {
			return this.success != null;
		}

		public void setSuccessIsSet(boolean value) {
			if (!value) {
				this.success = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SUCCESS:
				if (value == null) {
					unsetSuccess();
				} else {
					setSuccess((String) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SUCCESS:
				return getSuccess();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SUCCESS:
				return isSetSuccess();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof query_result)
				return this.equals((query_result) that);
			return false;
		}

		public boolean equals(query_result that) {
			if (that == null)
				return false;

			boolean this_present_success = true && this.isSetSuccess();
			boolean that_present_success = true && that.isSetSuccess();
			if (this_present_success || that_present_success) {
				if (!(this_present_success && that_present_success))
					return false;
				if (!this.success.equals(that.success))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(query_result other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSuccess()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("query_result(");
			boolean first = true;

			sb.append("success:");
			if (this.success == null) {
				sb.append("null");
			} else {
				sb.append(this.success);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class query_resultStandardSchemeFactory implements SchemeFactory {
			public query_resultStandardScheme getScheme() {
				return new query_resultStandardScheme();
			}
		}

		private static class query_resultStandardScheme extends StandardScheme<query_result> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, query_result struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 0: // SUCCESS
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.success = iprot.readString();
							struct.setSuccessIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, query_result struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.success != null) {
					oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
					oprot.writeString(struct.success);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class query_resultTupleSchemeFactory implements SchemeFactory {
			public query_resultTupleScheme getScheme() {
				return new query_resultTupleScheme();
			}
		}

		private static class query_resultTupleScheme extends TupleScheme<query_result> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, query_result struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSuccess()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetSuccess()) {
					oprot.writeString(struct.success);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, query_result struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					struct.success = iprot.readString();
					struct.setSuccessIsSet(true);
				}
			}
		}

	}

	@SuppressWarnings("serial")
	public static class getOffset_args implements org.apache.thrift.TBase<getOffset_args, getOffset_args._Fields>, java.io.Serializable, Cloneable, Comparable<getOffset_args> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getOffset_args");

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new getOffset_argsStandardSchemeFactory());
			schemes.put(TupleScheme.class, new getOffset_argsTupleSchemeFactory());
		}

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			;

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getOffset_args.class, metaDataMap);
		}

		public getOffset_args() {
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public getOffset_args(getOffset_args other) {
		}

		public getOffset_args deepCopy() {
			return new getOffset_args(this);
		}

		@Override
		public void clear() {
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof getOffset_args)
				return this.equals((getOffset_args) that);
			return false;
		}

		public boolean equals(getOffset_args that) {
			if (that == null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@SuppressWarnings("unused")
		@Override
		public int compareTo(getOffset_args other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("getOffset_args(");
			boolean first = true;

			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class getOffset_argsStandardSchemeFactory implements SchemeFactory {
			public getOffset_argsStandardScheme getScheme() {
				return new getOffset_argsStandardScheme();
			}
		}

		private static class getOffset_argsStandardScheme extends StandardScheme<getOffset_args> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, getOffset_args struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, getOffset_args struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class getOffset_argsTupleSchemeFactory implements SchemeFactory {
			public getOffset_argsTupleScheme getScheme() {
				return new getOffset_argsTupleScheme();
			}
		}

		private static class getOffset_argsTupleScheme extends TupleScheme<getOffset_args> {

			@SuppressWarnings("unused")
			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, getOffset_args struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
			}

			@SuppressWarnings("unused")
			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, getOffset_args struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
			}
		}

	}

	@SuppressWarnings("serial")
	public static class getOffset_result implements org.apache.thrift.TBase<getOffset_result, getOffset_result._Fields>, java.io.Serializable, Cloneable, Comparable<getOffset_result> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getOffset_result");

		private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short) 0);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new getOffset_resultStandardSchemeFactory());
			schemes.put(TupleScheme.class, new getOffset_resultTupleSchemeFactory());
		}

		public String success; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SUCCESS((short) 0, "success");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 0: // SUCCESS
					return SUCCESS;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getOffset_result.class, metaDataMap);
		}

		public getOffset_result() {
		}

		public getOffset_result(String success) {
			this();
			this.success = success;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public getOffset_result(getOffset_result other) {
			if (other.isSetSuccess()) {
				this.success = other.success;
			}
		}

		public getOffset_result deepCopy() {
			return new getOffset_result(this);
		}

		@Override
		public void clear() {
			this.success = null;
		}

		public String getSuccess() {
			return this.success;
		}

		public getOffset_result setSuccess(String success) {
			this.success = success;
			return this;
		}

		public void unsetSuccess() {
			this.success = null;
		}

		/**
		 * Returns true if field success is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSuccess() {
			return this.success != null;
		}

		public void setSuccessIsSet(boolean value) {
			if (!value) {
				this.success = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SUCCESS:
				if (value == null) {
					unsetSuccess();
				} else {
					setSuccess((String) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SUCCESS:
				return getSuccess();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SUCCESS:
				return isSetSuccess();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof getOffset_result)
				return this.equals((getOffset_result) that);
			return false;
		}

		public boolean equals(getOffset_result that) {
			if (that == null)
				return false;

			boolean this_present_success = true && this.isSetSuccess();
			boolean that_present_success = true && that.isSetSuccess();
			if (this_present_success || that_present_success) {
				if (!(this_present_success && that_present_success))
					return false;
				if (!this.success.equals(that.success))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(getOffset_result other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSuccess()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("getOffset_result(");
			boolean first = true;

			sb.append("success:");
			if (this.success == null) {
				sb.append("null");
			} else {
				sb.append(this.success);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class getOffset_resultStandardSchemeFactory implements SchemeFactory {
			public getOffset_resultStandardScheme getScheme() {
				return new getOffset_resultStandardScheme();
			}
		}

		private static class getOffset_resultStandardScheme extends StandardScheme<getOffset_result> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, getOffset_result struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 0: // SUCCESS
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.success = iprot.readString();
							struct.setSuccessIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, getOffset_result struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.success != null) {
					oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
					oprot.writeString(struct.success);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class getOffset_resultTupleSchemeFactory implements SchemeFactory {
			public getOffset_resultTupleScheme getScheme() {
				return new getOffset_resultTupleScheme();
			}
		}

		private static class getOffset_resultTupleScheme extends TupleScheme<getOffset_result> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, getOffset_result struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSuccess()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetSuccess()) {
					oprot.writeString(struct.success);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, getOffset_result struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					struct.success = iprot.readString();
					struct.setSuccessIsSet(true);
				}
			}
		}

	}

	@SuppressWarnings("serial")
	public static class sql_args implements org.apache.thrift.TBase<sql_args, sql_args._Fields>, java.io.Serializable, Cloneable, Comparable<sql_args> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("sql_args");

		private static final org.apache.thrift.protocol.TField SQL_FIELD_DESC = new org.apache.thrift.protocol.TField("sql", org.apache.thrift.protocol.TType.STRING, (short) 1);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new sql_argsStandardSchemeFactory());
			schemes.put(TupleScheme.class, new sql_argsTupleSchemeFactory());
		}

		public String sql; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SQL((short) 1, "sql");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 1: // SQL
					return SQL;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.SQL, new org.apache.thrift.meta_data.FieldMetaData("sql", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(sql_args.class, metaDataMap);
		}

		public sql_args() {
		}

		public sql_args(String sql) {
			this();
			this.sql = sql;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public sql_args(sql_args other) {
			if (other.isSetSql()) {
				this.sql = other.sql;
			}
		}

		public sql_args deepCopy() {
			return new sql_args(this);
		}

		@Override
		public void clear() {
			this.sql = null;
		}

		public String getSql() {
			return this.sql;
		}

		public sql_args setSql(String sql) {
			this.sql = sql;
			return this;
		}

		public void unsetSql() {
			this.sql = null;
		}

		/**
		 * Returns true if field sql is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSql() {
			return this.sql != null;
		}

		public void setSqlIsSet(boolean value) {
			if (!value) {
				this.sql = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SQL:
				if (value == null) {
					unsetSql();
				} else {
					setSql((String) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SQL:
				return getSql();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SQL:
				return isSetSql();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof sql_args)
				return this.equals((sql_args) that);
			return false;
		}

		public boolean equals(sql_args that) {
			if (that == null)
				return false;

			boolean this_present_sql = true && this.isSetSql();
			boolean that_present_sql = true && that.isSetSql();
			if (this_present_sql || that_present_sql) {
				if (!(this_present_sql && that_present_sql))
					return false;
				if (!this.sql.equals(that.sql))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(sql_args other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetSql()).compareTo(other.isSetSql());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSql()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.sql, other.sql);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("sql_args(");
			boolean first = true;

			sb.append("sql:");
			if (this.sql == null) {
				sb.append("null");
			} else {
				sb.append(this.sql);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class sql_argsStandardSchemeFactory implements SchemeFactory {
			public sql_argsStandardScheme getScheme() {
				return new sql_argsStandardScheme();
			}
		}

		private static class sql_argsStandardScheme extends StandardScheme<sql_args> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, sql_args struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 1: // SQL
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.sql = iprot.readString();
							struct.setSqlIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, sql_args struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.sql != null) {
					oprot.writeFieldBegin(SQL_FIELD_DESC);
					oprot.writeString(struct.sql);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class sql_argsTupleSchemeFactory implements SchemeFactory {
			public sql_argsTupleScheme getScheme() {
				return new sql_argsTupleScheme();
			}
		}

		private static class sql_argsTupleScheme extends TupleScheme<sql_args> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, sql_args struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSql()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetSql()) {
					oprot.writeString(struct.sql);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, sql_args struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					struct.sql = iprot.readString();
					struct.setSqlIsSet(true);
				}
			}
		}

	}

	@SuppressWarnings("serial")
	public static class sql_result implements org.apache.thrift.TBase<sql_result, sql_result._Fields>, java.io.Serializable, Cloneable, Comparable<sql_result> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("sql_result");

		private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short) 0);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new sql_resultStandardSchemeFactory());
			schemes.put(TupleScheme.class, new sql_resultTupleSchemeFactory());
		}

		public String success; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SUCCESS((short) 0, "success");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 0: // SUCCESS
					return SUCCESS;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(sql_result.class, metaDataMap);
		}

		public sql_result() {
		}

		public sql_result(String success) {
			this();
			this.success = success;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public sql_result(sql_result other) {
			if (other.isSetSuccess()) {
				this.success = other.success;
			}
		}

		public sql_result deepCopy() {
			return new sql_result(this);
		}

		@Override
		public void clear() {
			this.success = null;
		}

		public String getSuccess() {
			return this.success;
		}

		public sql_result setSuccess(String success) {
			this.success = success;
			return this;
		}

		public void unsetSuccess() {
			this.success = null;
		}

		/**
		 * Returns true if field success is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSuccess() {
			return this.success != null;
		}

		public void setSuccessIsSet(boolean value) {
			if (!value) {
				this.success = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SUCCESS:
				if (value == null) {
					unsetSuccess();
				} else {
					setSuccess((String) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SUCCESS:
				return getSuccess();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SUCCESS:
				return isSetSuccess();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof sql_result)
				return this.equals((sql_result) that);
			return false;
		}

		public boolean equals(sql_result that) {
			if (that == null)
				return false;

			boolean this_present_success = true && this.isSetSuccess();
			boolean that_present_success = true && that.isSetSuccess();
			if (this_present_success || that_present_success) {
				if (!(this_present_success && that_present_success))
					return false;
				if (!this.success.equals(that.success))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(sql_result other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSuccess()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("sql_result(");
			boolean first = true;

			sb.append("success:");
			if (this.success == null) {
				sb.append("null");
			} else {
				sb.append(this.success);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class sql_resultStandardSchemeFactory implements SchemeFactory {
			public sql_resultStandardScheme getScheme() {
				return new sql_resultStandardScheme();
			}
		}

		private static class sql_resultStandardScheme extends StandardScheme<sql_result> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, sql_result struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 0: // SUCCESS
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.success = iprot.readString();
							struct.setSuccessIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, sql_result struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.success != null) {
					oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
					oprot.writeString(struct.success);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class sql_resultTupleSchemeFactory implements SchemeFactory {
			public sql_resultTupleScheme getScheme() {
				return new sql_resultTupleScheme();
			}
		}

		private static class sql_resultTupleScheme extends TupleScheme<sql_result> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, sql_result struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSuccess()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetSuccess()) {
					oprot.writeString(struct.success);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, sql_result struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					struct.success = iprot.readString();
					struct.setSuccessIsSet(true);
				}
			}
		}

	}

	@SuppressWarnings("serial")
	public static class getConsumer_args implements org.apache.thrift.TBase<getConsumer_args, getConsumer_args._Fields>, java.io.Serializable, Cloneable, Comparable<getConsumer_args> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getConsumer_args");

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new getConsumer_argsStandardSchemeFactory());
			schemes.put(TupleScheme.class, new getConsumer_argsTupleSchemeFactory());
		}

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			;

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getConsumer_args.class, metaDataMap);
		}

		public getConsumer_args() {
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public getConsumer_args(getConsumer_args other) {
		}

		public getConsumer_args deepCopy() {
			return new getConsumer_args(this);
		}

		@Override
		public void clear() {
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof getConsumer_args)
				return this.equals((getConsumer_args) that);
			return false;
		}

		public boolean equals(getConsumer_args that) {
			if (that == null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@SuppressWarnings("unused")
		@Override
		public int compareTo(getConsumer_args other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("getConsumer_args(");
			boolean first = true;

			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class getConsumer_argsStandardSchemeFactory implements SchemeFactory {
			public getConsumer_argsStandardScheme getScheme() {
				return new getConsumer_argsStandardScheme();
			}
		}

		private static class getConsumer_argsStandardScheme extends StandardScheme<getConsumer_args> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, getConsumer_args struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, getConsumer_args struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class getConsumer_argsTupleSchemeFactory implements SchemeFactory {
			public getConsumer_argsTupleScheme getScheme() {
				return new getConsumer_argsTupleScheme();
			}
		}

		private static class getConsumer_argsTupleScheme extends TupleScheme<getConsumer_args> {

			@SuppressWarnings("unused")
			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, getConsumer_args struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
			}

			@SuppressWarnings("unused")
			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, getConsumer_args struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
			}
		}

	}

	@SuppressWarnings("serial")
	public static class getConsumer_result implements org.apache.thrift.TBase<getConsumer_result, getConsumer_result._Fields>, java.io.Serializable, Cloneable, Comparable<getConsumer_result> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getConsumer_result");

		private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short) 0);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new getConsumer_resultStandardSchemeFactory());
			schemes.put(TupleScheme.class, new getConsumer_resultTupleSchemeFactory());
		}

		public String success; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SUCCESS((short) 0, "success");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 0: // SUCCESS
					return SUCCESS;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getConsumer_result.class, metaDataMap);
		}

		public getConsumer_result() {
		}

		public getConsumer_result(String success) {
			this();
			this.success = success;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public getConsumer_result(getConsumer_result other) {
			if (other.isSetSuccess()) {
				this.success = other.success;
			}
		}

		public getConsumer_result deepCopy() {
			return new getConsumer_result(this);
		}

		@Override
		public void clear() {
			this.success = null;
		}

		public String getSuccess() {
			return this.success;
		}

		public getConsumer_result setSuccess(String success) {
			this.success = success;
			return this;
		}

		public void unsetSuccess() {
			this.success = null;
		}

		/**
		 * Returns true if field success is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSuccess() {
			return this.success != null;
		}

		public void setSuccessIsSet(boolean value) {
			if (!value) {
				this.success = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SUCCESS:
				if (value == null) {
					unsetSuccess();
				} else {
					setSuccess((String) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SUCCESS:
				return getSuccess();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SUCCESS:
				return isSetSuccess();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof getConsumer_result)
				return this.equals((getConsumer_result) that);
			return false;
		}

		public boolean equals(getConsumer_result that) {
			if (that == null)
				return false;

			boolean this_present_success = true && this.isSetSuccess();
			boolean that_present_success = true && that.isSetSuccess();
			if (this_present_success || that_present_success) {
				if (!(this_present_success && that_present_success))
					return false;
				if (!this.success.equals(that.success))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(getConsumer_result other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSuccess()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("getConsumer_result(");
			boolean first = true;

			sb.append("success:");
			if (this.success == null) {
				sb.append("null");
			} else {
				sb.append(this.success);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class getConsumer_resultStandardSchemeFactory implements SchemeFactory {
			public getConsumer_resultStandardScheme getScheme() {
				return new getConsumer_resultStandardScheme();
			}
		}

		private static class getConsumer_resultStandardScheme extends StandardScheme<getConsumer_result> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, getConsumer_result struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 0: // SUCCESS
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.success = iprot.readString();
							struct.setSuccessIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, getConsumer_result struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.success != null) {
					oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
					oprot.writeString(struct.success);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class getConsumer_resultTupleSchemeFactory implements SchemeFactory {
			public getConsumer_resultTupleScheme getScheme() {
				return new getConsumer_resultTupleScheme();
			}
		}

		private static class getConsumer_resultTupleScheme extends TupleScheme<getConsumer_result> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, getConsumer_result struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSuccess()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetSuccess()) {
					oprot.writeString(struct.success);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, getConsumer_result struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					struct.success = iprot.readString();
					struct.setSuccessIsSet(true);
				}
			}
		}

	}

	@SuppressWarnings("serial")
	public static class getConsumerPage_args implements org.apache.thrift.TBase<getConsumerPage_args, getConsumerPage_args._Fields>, java.io.Serializable, Cloneable, Comparable<getConsumerPage_args> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getConsumerPage_args");

		private static final org.apache.thrift.protocol.TField SEARCH_FIELD_DESC = new org.apache.thrift.protocol.TField("search", org.apache.thrift.protocol.TType.STRING, (short) 1);
		private static final org.apache.thrift.protocol.TField I_DISPLAY_START_FIELD_DESC = new org.apache.thrift.protocol.TField("iDisplayStart", org.apache.thrift.protocol.TType.I32, (short) 2);
		private static final org.apache.thrift.protocol.TField I_DISPLAY_LENGTH_FIELD_DESC = new org.apache.thrift.protocol.TField("iDisplayLength", org.apache.thrift.protocol.TType.I32, (short) 3);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new getConsumerPage_argsStandardSchemeFactory());
			schemes.put(TupleScheme.class, new getConsumerPage_argsTupleSchemeFactory());
		}

		public String search; // required
		public int iDisplayStart; // required
		public int iDisplayLength; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SEARCH((short) 1, "search"), I_DISPLAY_START((short) 2, "iDisplayStart"), I_DISPLAY_LENGTH((short) 3, "iDisplayLength");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 1: // SEARCH
					return SEARCH;
				case 2: // I_DISPLAY_START
					return I_DISPLAY_START;
				case 3: // I_DISPLAY_LENGTH
					return I_DISPLAY_LENGTH;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		private static final int __IDISPLAYSTART_ISSET_ID = 0;
		private static final int __IDISPLAYLENGTH_ISSET_ID = 1;
		private byte __isset_bitfield = 0;
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.SEARCH, new org.apache.thrift.meta_data.FieldMetaData("search", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			tmpMap.put(_Fields.I_DISPLAY_START,
					new org.apache.thrift.meta_data.FieldMetaData("iDisplayStart", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
			tmpMap.put(_Fields.I_DISPLAY_LENGTH,
					new org.apache.thrift.meta_data.FieldMetaData("iDisplayLength", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getConsumerPage_args.class, metaDataMap);
		}

		public getConsumerPage_args() {
		}

		public getConsumerPage_args(String search, int iDisplayStart, int iDisplayLength) {
			this();
			this.search = search;
			this.iDisplayStart = iDisplayStart;
			setIDisplayStartIsSet(true);
			this.iDisplayLength = iDisplayLength;
			setIDisplayLengthIsSet(true);
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public getConsumerPage_args(getConsumerPage_args other) {
			__isset_bitfield = other.__isset_bitfield;
			if (other.isSetSearch()) {
				this.search = other.search;
			}
			this.iDisplayStart = other.iDisplayStart;
			this.iDisplayLength = other.iDisplayLength;
		}

		public getConsumerPage_args deepCopy() {
			return new getConsumerPage_args(this);
		}

		@Override
		public void clear() {
			this.search = null;
			setIDisplayStartIsSet(false);
			this.iDisplayStart = 0;
			setIDisplayLengthIsSet(false);
			this.iDisplayLength = 0;
		}

		public String getSearch() {
			return this.search;
		}

		public getConsumerPage_args setSearch(String search) {
			this.search = search;
			return this;
		}

		public void unsetSearch() {
			this.search = null;
		}

		/**
		 * Returns true if field search is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSearch() {
			return this.search != null;
		}

		public void setSearchIsSet(boolean value) {
			if (!value) {
				this.search = null;
			}
		}

		public int getIDisplayStart() {
			return this.iDisplayStart;
		}

		public getConsumerPage_args setIDisplayStart(int iDisplayStart) {
			this.iDisplayStart = iDisplayStart;
			setIDisplayStartIsSet(true);
			return this;
		}

		public void unsetIDisplayStart() {
			__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __IDISPLAYSTART_ISSET_ID);
		}

		/**
		 * Returns true if field iDisplayStart is set (has been assigned a
		 * value) and false otherwise
		 */
		public boolean isSetIDisplayStart() {
			return EncodingUtils.testBit(__isset_bitfield, __IDISPLAYSTART_ISSET_ID);
		}

		public void setIDisplayStartIsSet(boolean value) {
			__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __IDISPLAYSTART_ISSET_ID, value);
		}

		public int getIDisplayLength() {
			return this.iDisplayLength;
		}

		public getConsumerPage_args setIDisplayLength(int iDisplayLength) {
			this.iDisplayLength = iDisplayLength;
			setIDisplayLengthIsSet(true);
			return this;
		}

		public void unsetIDisplayLength() {
			__isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __IDISPLAYLENGTH_ISSET_ID);
		}

		/**
		 * Returns true if field iDisplayLength is set (has been assigned a
		 * value) and false otherwise
		 */
		public boolean isSetIDisplayLength() {
			return EncodingUtils.testBit(__isset_bitfield, __IDISPLAYLENGTH_ISSET_ID);
		}

		public void setIDisplayLengthIsSet(boolean value) {
			__isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __IDISPLAYLENGTH_ISSET_ID, value);
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SEARCH:
				if (value == null) {
					unsetSearch();
				} else {
					setSearch((String) value);
				}
				break;

			case I_DISPLAY_START:
				if (value == null) {
					unsetIDisplayStart();
				} else {
					setIDisplayStart((Integer) value);
				}
				break;

			case I_DISPLAY_LENGTH:
				if (value == null) {
					unsetIDisplayLength();
				} else {
					setIDisplayLength((Integer) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SEARCH:
				return getSearch();

			case I_DISPLAY_START:
				return Integer.valueOf(getIDisplayStart());

			case I_DISPLAY_LENGTH:
				return Integer.valueOf(getIDisplayLength());

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SEARCH:
				return isSetSearch();
			case I_DISPLAY_START:
				return isSetIDisplayStart();
			case I_DISPLAY_LENGTH:
				return isSetIDisplayLength();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof getConsumerPage_args)
				return this.equals((getConsumerPage_args) that);
			return false;
		}

		public boolean equals(getConsumerPage_args that) {
			if (that == null)
				return false;

			boolean this_present_search = true && this.isSetSearch();
			boolean that_present_search = true && that.isSetSearch();
			if (this_present_search || that_present_search) {
				if (!(this_present_search && that_present_search))
					return false;
				if (!this.search.equals(that.search))
					return false;
			}

			boolean this_present_iDisplayStart = true;
			boolean that_present_iDisplayStart = true;
			if (this_present_iDisplayStart || that_present_iDisplayStart) {
				if (!(this_present_iDisplayStart && that_present_iDisplayStart))
					return false;
				if (this.iDisplayStart != that.iDisplayStart)
					return false;
			}

			boolean this_present_iDisplayLength = true;
			boolean that_present_iDisplayLength = true;
			if (this_present_iDisplayLength || that_present_iDisplayLength) {
				if (!(this_present_iDisplayLength && that_present_iDisplayLength))
					return false;
				if (this.iDisplayLength != that.iDisplayLength)
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(getConsumerPage_args other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetSearch()).compareTo(other.isSetSearch());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSearch()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.search, other.search);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			lastComparison = Boolean.valueOf(isSetIDisplayStart()).compareTo(other.isSetIDisplayStart());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetIDisplayStart()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iDisplayStart, other.iDisplayStart);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			lastComparison = Boolean.valueOf(isSetIDisplayLength()).compareTo(other.isSetIDisplayLength());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetIDisplayLength()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.iDisplayLength, other.iDisplayLength);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("getConsumerPage_args(");
			boolean first = true;

			sb.append("search:");
			if (this.search == null) {
				sb.append("null");
			} else {
				sb.append(this.search);
			}
			first = false;
			if (!first)
				sb.append(", ");
			sb.append("iDisplayStart:");
			sb.append(this.iDisplayStart);
			first = false;
			if (!first)
				sb.append(", ");
			sb.append("iDisplayLength:");
			sb.append(this.iDisplayLength);
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				// it doesn't seem like you should have to do this, but java
				// serialization is wacky, and doesn't call the default
				// constructor.
				__isset_bitfield = 0;
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class getConsumerPage_argsStandardSchemeFactory implements SchemeFactory {
			public getConsumerPage_argsStandardScheme getScheme() {
				return new getConsumerPage_argsStandardScheme();
			}
		}

		private static class getConsumerPage_argsStandardScheme extends StandardScheme<getConsumerPage_args> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, getConsumerPage_args struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 1: // SEARCH
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.search = iprot.readString();
							struct.setSearchIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 2: // I_DISPLAY_START
						if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
							struct.iDisplayStart = iprot.readI32();
							struct.setIDisplayStartIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					case 3: // I_DISPLAY_LENGTH
						if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
							struct.iDisplayLength = iprot.readI32();
							struct.setIDisplayLengthIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, getConsumerPage_args struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.search != null) {
					oprot.writeFieldBegin(SEARCH_FIELD_DESC);
					oprot.writeString(struct.search);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldBegin(I_DISPLAY_START_FIELD_DESC);
				oprot.writeI32(struct.iDisplayStart);
				oprot.writeFieldEnd();
				oprot.writeFieldBegin(I_DISPLAY_LENGTH_FIELD_DESC);
				oprot.writeI32(struct.iDisplayLength);
				oprot.writeFieldEnd();
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class getConsumerPage_argsTupleSchemeFactory implements SchemeFactory {
			public getConsumerPage_argsTupleScheme getScheme() {
				return new getConsumerPage_argsTupleScheme();
			}
		}

		private static class getConsumerPage_argsTupleScheme extends TupleScheme<getConsumerPage_args> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, getConsumerPage_args struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSearch()) {
					optionals.set(0);
				}
				if (struct.isSetIDisplayStart()) {
					optionals.set(1);
				}
				if (struct.isSetIDisplayLength()) {
					optionals.set(2);
				}
				oprot.writeBitSet(optionals, 3);
				if (struct.isSetSearch()) {
					oprot.writeString(struct.search);
				}
				if (struct.isSetIDisplayStart()) {
					oprot.writeI32(struct.iDisplayStart);
				}
				if (struct.isSetIDisplayLength()) {
					oprot.writeI32(struct.iDisplayLength);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, getConsumerPage_args struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(3);
				if (incoming.get(0)) {
					struct.search = iprot.readString();
					struct.setSearchIsSet(true);
				}
				if (incoming.get(1)) {
					struct.iDisplayStart = iprot.readI32();
					struct.setIDisplayStartIsSet(true);
				}
				if (incoming.get(2)) {
					struct.iDisplayLength = iprot.readI32();
					struct.setIDisplayLengthIsSet(true);
				}
			}
		}

	}

	@SuppressWarnings("serial")
	public static class getConsumerPage_result implements org.apache.thrift.TBase<getConsumerPage_result, getConsumerPage_result._Fields>, java.io.Serializable, Cloneable, Comparable<getConsumerPage_result> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getConsumerPage_result");

		private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short) 0);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new getConsumerPage_resultStandardSchemeFactory());
			schemes.put(TupleScheme.class, new getConsumerPage_resultTupleSchemeFactory());
		}

		public String success; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SUCCESS((short) 0, "success");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 0: // SUCCESS
					return SUCCESS;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getConsumerPage_result.class, metaDataMap);
		}

		public getConsumerPage_result() {
		}

		public getConsumerPage_result(String success) {
			this();
			this.success = success;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public getConsumerPage_result(getConsumerPage_result other) {
			if (other.isSetSuccess()) {
				this.success = other.success;
			}
		}

		public getConsumerPage_result deepCopy() {
			return new getConsumerPage_result(this);
		}

		@Override
		public void clear() {
			this.success = null;
		}

		public String getSuccess() {
			return this.success;
		}

		public getConsumerPage_result setSuccess(String success) {
			this.success = success;
			return this;
		}

		public void unsetSuccess() {
			this.success = null;
		}

		/**
		 * Returns true if field success is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSuccess() {
			return this.success != null;
		}

		public void setSuccessIsSet(boolean value) {
			if (!value) {
				this.success = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SUCCESS:
				if (value == null) {
					unsetSuccess();
				} else {
					setSuccess((String) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SUCCESS:
				return getSuccess();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SUCCESS:
				return isSetSuccess();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof getConsumerPage_result)
				return this.equals((getConsumerPage_result) that);
			return false;
		}

		public boolean equals(getConsumerPage_result that) {
			if (that == null)
				return false;

			boolean this_present_success = true && this.isSetSuccess();
			boolean that_present_success = true && that.isSetSuccess();
			if (this_present_success || that_present_success) {
				if (!(this_present_success && that_present_success))
					return false;
				if (!this.success.equals(that.success))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(getConsumerPage_result other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSuccess()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("getConsumerPage_result(");
			boolean first = true;

			sb.append("success:");
			if (this.success == null) {
				sb.append("null");
			} else {
				sb.append(this.success);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class getConsumerPage_resultStandardSchemeFactory implements SchemeFactory {
			public getConsumerPage_resultStandardScheme getScheme() {
				return new getConsumerPage_resultStandardScheme();
			}
		}

		private static class getConsumerPage_resultStandardScheme extends StandardScheme<getConsumerPage_result> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, getConsumerPage_result struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 0: // SUCCESS
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.success = iprot.readString();
							struct.setSuccessIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, getConsumerPage_result struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.success != null) {
					oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
					oprot.writeString(struct.success);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class getConsumerPage_resultTupleSchemeFactory implements SchemeFactory {
			public getConsumerPage_resultTupleScheme getScheme() {
				return new getConsumerPage_resultTupleScheme();
			}
		}

		private static class getConsumerPage_resultTupleScheme extends TupleScheme<getConsumerPage_result> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, getConsumerPage_result struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSuccess()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetSuccess()) {
					oprot.writeString(struct.success);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, getConsumerPage_result struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					struct.success = iprot.readString();
					struct.setSuccessIsSet(true);
				}
			}
		}

	}

	@SuppressWarnings("serial")
	public static class getActiverConsumer_args implements org.apache.thrift.TBase<getActiverConsumer_args, getActiverConsumer_args._Fields>, java.io.Serializable, Cloneable, Comparable<getActiverConsumer_args> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getActiverConsumer_args");

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new getActiverConsumer_argsStandardSchemeFactory());
			schemes.put(TupleScheme.class, new getActiverConsumer_argsTupleSchemeFactory());
		}

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			;

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getActiverConsumer_args.class, metaDataMap);
		}

		public getActiverConsumer_args() {
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public getActiverConsumer_args(getActiverConsumer_args other) {
		}

		public getActiverConsumer_args deepCopy() {
			return new getActiverConsumer_args(this);
		}

		@Override
		public void clear() {
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof getActiverConsumer_args)
				return this.equals((getActiverConsumer_args) that);
			return false;
		}

		public boolean equals(getActiverConsumer_args that) {
			if (that == null)
				return false;

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@SuppressWarnings("unused")
		@Override
		public int compareTo(getActiverConsumer_args other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("getActiverConsumer_args(");
			boolean first = true;

			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class getActiverConsumer_argsStandardSchemeFactory implements SchemeFactory {
			public getActiverConsumer_argsStandardScheme getScheme() {
				return new getActiverConsumer_argsStandardScheme();
			}
		}

		private static class getActiverConsumer_argsStandardScheme extends StandardScheme<getActiverConsumer_args> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, getActiverConsumer_args struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, getActiverConsumer_args struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class getActiverConsumer_argsTupleSchemeFactory implements SchemeFactory {
			public getActiverConsumer_argsTupleScheme getScheme() {
				return new getActiverConsumer_argsTupleScheme();
			}
		}

		private static class getActiverConsumer_argsTupleScheme extends TupleScheme<getActiverConsumer_args> {

			@SuppressWarnings("unused")
			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, getActiverConsumer_args struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
			}

			@SuppressWarnings("unused")
			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, getActiverConsumer_args struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
			}
		}

	}

	@SuppressWarnings("serial")
	public static class getActiverConsumer_result implements org.apache.thrift.TBase<getActiverConsumer_result, getActiverConsumer_result._Fields>, java.io.Serializable, Cloneable, Comparable<getActiverConsumer_result> {
		private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getActiverConsumer_result");

		private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRING, (short) 0);

		private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
		static {
			schemes.put(StandardScheme.class, new getActiverConsumer_resultStandardSchemeFactory());
			schemes.put(TupleScheme.class, new getActiverConsumer_resultTupleSchemeFactory());
		}

		public String success; // required

		/**
		 * The set of fields this struct contains, along with convenience
		 * methods for finding and manipulating them.
		 */
		public enum _Fields implements org.apache.thrift.TFieldIdEnum {
			SUCCESS((short) 0, "success");

			private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

			static {
				for (_Fields field : EnumSet.allOf(_Fields.class)) {
					byName.put(field.getFieldName(), field);
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, or null if its
			 * not found.
			 */
			public static _Fields findByThriftId(int fieldId) {
				switch (fieldId) {
				case 0: // SUCCESS
					return SUCCESS;
				default:
					return null;
				}
			}

			/**
			 * Find the _Fields constant that matches fieldId, throwing an
			 * exception if it is not found.
			 */
			public static _Fields findByThriftIdOrThrow(int fieldId) {
				_Fields fields = findByThriftId(fieldId);
				if (fields == null)
					throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
				return fields;
			}

			/**
			 * Find the _Fields constant that matches name, or null if its not
			 * found.
			 */
			public static _Fields findByName(String name) {
				return byName.get(name);
			}

			private final short _thriftId;
			private final String _fieldName;

			_Fields(short thriftId, String fieldName) {
				_thriftId = thriftId;
				_fieldName = fieldName;
			}

			public short getThriftFieldId() {
				return _thriftId;
			}

			public String getFieldName() {
				return _fieldName;
			}
		}

		// isset id assignments
		public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
		static {
			Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
			tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
			metaDataMap = Collections.unmodifiableMap(tmpMap);
			org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getActiverConsumer_result.class, metaDataMap);
		}

		public getActiverConsumer_result() {
		}

		public getActiverConsumer_result(String success) {
			this();
			this.success = success;
		}

		/**
		 * Performs a deep copy on <i>other</i>.
		 */
		public getActiverConsumer_result(getActiverConsumer_result other) {
			if (other.isSetSuccess()) {
				this.success = other.success;
			}
		}

		public getActiverConsumer_result deepCopy() {
			return new getActiverConsumer_result(this);
		}

		@Override
		public void clear() {
			this.success = null;
		}

		public String getSuccess() {
			return this.success;
		}

		public getActiverConsumer_result setSuccess(String success) {
			this.success = success;
			return this;
		}

		public void unsetSuccess() {
			this.success = null;
		}

		/**
		 * Returns true if field success is set (has been assigned a value) and
		 * false otherwise
		 */
		public boolean isSetSuccess() {
			return this.success != null;
		}

		public void setSuccessIsSet(boolean value) {
			if (!value) {
				this.success = null;
			}
		}

		public void setFieldValue(_Fields field, Object value) {
			switch (field) {
			case SUCCESS:
				if (value == null) {
					unsetSuccess();
				} else {
					setSuccess((String) value);
				}
				break;

			}
		}

		public Object getFieldValue(_Fields field) {
			switch (field) {
			case SUCCESS:
				return getSuccess();

			}
			throw new IllegalStateException();
		}

		/**
		 * Returns true if field corresponding to fieldID is set (has been
		 * assigned a value) and false otherwise
		 */
		public boolean isSet(_Fields field) {
			if (field == null) {
				throw new IllegalArgumentException();
			}

			switch (field) {
			case SUCCESS:
				return isSetSuccess();
			}
			throw new IllegalStateException();
		}

		@Override
		public boolean equals(Object that) {
			if (that == null)
				return false;
			if (that instanceof getActiverConsumer_result)
				return this.equals((getActiverConsumer_result) that);
			return false;
		}

		public boolean equals(getActiverConsumer_result that) {
			if (that == null)
				return false;

			boolean this_present_success = true && this.isSetSuccess();
			boolean that_present_success = true && that.isSetSuccess();
			if (this_present_success || that_present_success) {
				if (!(this_present_success && that_present_success))
					return false;
				if (!this.success.equals(that.success))
					return false;
			}

			return true;
		}

		@Override
		public int hashCode() {
			return 0;
		}

		@Override
		public int compareTo(getActiverConsumer_result other) {
			if (!getClass().equals(other.getClass())) {
				return getClass().getName().compareTo(other.getClass().getName());
			}

			int lastComparison = 0;

			lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
			if (lastComparison != 0) {
				return lastComparison;
			}
			if (isSetSuccess()) {
				lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
				if (lastComparison != 0) {
					return lastComparison;
				}
			}
			return 0;
		}

		public _Fields fieldForId(int fieldId) {
			return _Fields.findByThriftId(fieldId);
		}

		public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
			schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
		}

		public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
			schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
		}

		@SuppressWarnings("unused")
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("getActiverConsumer_result(");
			boolean first = true;

			sb.append("success:");
			if (this.success == null) {
				sb.append("null");
			} else {
				sb.append(this.success);
			}
			first = false;
			sb.append(")");
			return sb.toString();
		}

		public void validate() throws org.apache.thrift.TException {
			// check for required fields
			// check for sub-struct validity
		}

		private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
			try {
				write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
			try {
				read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
			} catch (org.apache.thrift.TException te) {
				throw new java.io.IOException(te);
			}
		}

		private static class getActiverConsumer_resultStandardSchemeFactory implements SchemeFactory {
			public getActiverConsumer_resultStandardScheme getScheme() {
				return new getActiverConsumer_resultStandardScheme();
			}
		}

		private static class getActiverConsumer_resultStandardScheme extends StandardScheme<getActiverConsumer_result> {

			public void read(org.apache.thrift.protocol.TProtocol iprot, getActiverConsumer_result struct) throws org.apache.thrift.TException {
				org.apache.thrift.protocol.TField schemeField;
				iprot.readStructBegin();
				while (true) {
					schemeField = iprot.readFieldBegin();
					if (schemeField.type == org.apache.thrift.protocol.TType.STOP) {
						break;
					}
					switch (schemeField.id) {
					case 0: // SUCCESS
						if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
							struct.success = iprot.readString();
							struct.setSuccessIsSet(true);
						} else {
							org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
						}
						break;
					default:
						org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
					}
					iprot.readFieldEnd();
				}
				iprot.readStructEnd();

				// check for required fields of primitive type, which can't be
				// checked in the validate method
				struct.validate();
			}

			public void write(org.apache.thrift.protocol.TProtocol oprot, getActiverConsumer_result struct) throws org.apache.thrift.TException {
				struct.validate();

				oprot.writeStructBegin(STRUCT_DESC);
				if (struct.success != null) {
					oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
					oprot.writeString(struct.success);
					oprot.writeFieldEnd();
				}
				oprot.writeFieldStop();
				oprot.writeStructEnd();
			}

		}

		private static class getActiverConsumer_resultTupleSchemeFactory implements SchemeFactory {
			public getActiverConsumer_resultTupleScheme getScheme() {
				return new getActiverConsumer_resultTupleScheme();
			}
		}

		private static class getActiverConsumer_resultTupleScheme extends TupleScheme<getActiverConsumer_result> {

			@Override
			public void write(org.apache.thrift.protocol.TProtocol prot, getActiverConsumer_result struct) throws org.apache.thrift.TException {
				TTupleProtocol oprot = (TTupleProtocol) prot;
				BitSet optionals = new BitSet();
				if (struct.isSetSuccess()) {
					optionals.set(0);
				}
				oprot.writeBitSet(optionals, 1);
				if (struct.isSetSuccess()) {
					oprot.writeString(struct.success);
				}
			}

			@Override
			public void read(org.apache.thrift.protocol.TProtocol prot, getActiverConsumer_result struct) throws org.apache.thrift.TException {
				TTupleProtocol iprot = (TTupleProtocol) prot;
				BitSet incoming = iprot.readBitSet(1);
				if (incoming.get(0)) {
					struct.success = iprot.readString();
					struct.setSuccessIsSet(true);
				}
			}
		}

	}

}
