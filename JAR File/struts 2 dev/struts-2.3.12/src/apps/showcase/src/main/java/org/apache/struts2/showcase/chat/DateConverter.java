y>
            <groupId>commons-el</groupId>
            <artifactId>commons-el</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- Test dependencies -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <reporting>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>rat-maven-plugin</artifactId>
                <version>1.0-alpha-2</version>
                <configuration>
                    <includes>
                        <include>pom.xml</include>
                        <include>src/**</include>
                    </includes>
                    <excludes>
                        <exclude>src/main/resources/org/apache/struts2/sitegraph/sitegraph-usage.txt</exclude>
                        <exclude>src/test/resources/org/apache/struts2/sitegraph/out.txt</exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </reporting>
</project>
                                                                                                                                                                                                                                       