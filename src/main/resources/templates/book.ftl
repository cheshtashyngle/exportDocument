<?xml version="1.0" encoding="UTF-8"?>
<jasperReport xmlns="http://jasperreports.sourceforge.net/jasperreports"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://jasperreports.sourceforge.net/jasperreports
              http://jasperreports.sourceforge.net/xsd/jasperreport.xsd"
              name="DataSourceReport" pageWidth="595" pageHeight="842"
              columnWidth="515" leftMargin="40" rightMargin="40" topMargin="50"
              bottomMargin="50" uuid="030574cb-2d4b-4281-8294-0f87619f0d8f">
    <parameter name="reportTitle" class="java.lang.String"/>

    <#list columnDataList as columnData>
    <field name= "${columnData.id}"  class= "${columnData.type.getName()}"/>
    </#list>
    <title>
        <band height="70">
            <line>
                <reportElement x="0" y="0" width="515" height="1" uuid="4058d4f4-b73d-4f3f-80db-3b2857ffb945"/>
            </line>
            <textField isBlankWhenNull="true">
                <reportElement x="0" y="10" width="515" height="30" uuid="fe78690f-568a-4de4-950e-2355cbc905f1"/>
                <textElement textAlignment="Center">
                    <font size="22"/>
                </textElement>
                <textFieldExpression><![CDATA[$P{reportTitle}]]></textFieldExpression>
            </textField>
        </band>
    </title>
    <pageHeader>
        <#assign x = 0>
        <band height="20" >
            <#list columnDataList as columnData>
                <staticText>
                    <reportElement positionType = "Float" stretchType = "RelativeToTallestObject" mode="Opaque"  x="${x}" y="5"
                                   width="${columnData.width}" height="15" forecolor="#FFFFFF" backcolor="#333333"/>
                    <textElement textAlignment="Center"/>
                    <text><![CDATA[${columnData.name}]]></text>
                </staticText>
                <#assign x = x + columnData.width>
            </#list>
        </band>
    </pageHeader>
    <detail>
        <#assign x = 0>
        <band height="15">
            <#list columnDataList as columnData>
                <textField isStretchWithOverflow = "true"
                        <#if columnData.formatPattern??> pattern = "${columnData.formatPattern}"</#if>>
                    <reportElement positionType = "Float" stretchType = "RelativeToTallestObject"
                                   x="${x}" y="0" width="${columnData.width}" height="15"/>
                    <box leftPadding="10" rightPadding="10">
                        <leftPen lineWidth="0.5"/>
                        <bottomPen lineWidth="0.5"/>
                    </box>
                    <textElement textAlignment="Right"/>
                    <textFieldExpression><![CDATA[$F{${columnData.id}}]]></textFieldExpression>
                </textField>
                <#assign x = x + columnData.width>
            </#list>
        </band>
    </detail>
</jasperReport>
