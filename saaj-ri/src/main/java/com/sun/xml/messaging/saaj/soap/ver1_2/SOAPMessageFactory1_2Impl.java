/*
 * Copyright (c) 1997, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

/**
*
* @author JAX-RPC RI Development Team
*/
package com.sun.xml.messaging.saaj.soap.ver1_2;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.soap.*;

import com.sun.xml.messaging.saaj.SOAPExceptionImpl;
import com.sun.xml.messaging.saaj.soap.MessageFactoryImpl;
import com.sun.xml.messaging.saaj.soap.MessageImpl;

public class SOAPMessageFactory1_2Impl extends MessageFactoryImpl {

    @Override
    public SOAPMessage createMessage() throws SOAPException {
        return new Message1_2Impl();
    }

    @Override
    public SOAPMessage createMessage(boolean isFastInfoset, 
        boolean acceptFastInfoset) throws SOAPException 
    {
        return new Message1_2Impl(isFastInfoset, acceptFastInfoset);
    }
    
    @Override
    public SOAPMessage createMessage(MimeHeaders headers, InputStream in) throws IOException, SOAPExceptionImpl {

        if (headers == null) {
            headers = new MimeHeaders();
        }

        if (getContentType(headers) == null) {
            headers.setHeader("Content-Type", SOAPConstants.SOAP_1_2_CONTENT_TYPE);
        }

        MessageImpl msg = new Message1_2Impl(headers, in);
        msg.setLazyAttachments(lazyAttachments);
        return msg;
    }
}