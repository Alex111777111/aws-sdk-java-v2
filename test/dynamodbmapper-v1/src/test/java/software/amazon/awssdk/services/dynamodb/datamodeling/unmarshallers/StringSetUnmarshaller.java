/*
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.services.dynamodb.datamodeling.unmarshallers;

import java.util.HashSet;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

/**
 * An unmarshaller that unmarshals DynamoDB StringSets as sets of Java
 * {@code String} objects.
 */
public class StringSetUnmarshaller extends SsUnmarshaller {

    private static final StringSetUnmarshaller INSTANCE =
            new StringSetUnmarshaller();

    private StringSetUnmarshaller() {
    }

    public static StringSetUnmarshaller instance() {
        return INSTANCE;
    }

    @Override
    public Object unmarshall(AttributeValue value) {
        return new HashSet<String>(value.ss());
    }
}
