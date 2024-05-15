import React, { useState } from "react";
import { View, TextInput, Text, TouchableOpacity, Alert, StyleSheet } from "react-native";

import { useNavigation } from "@react-navigation/native";

export default function Form() {
    const navigation = useNavigation();

    const [matricula, setMatricula] = useState(null)
    const [senha, setSenha] = useState(null)
    const [textButton] = useState("Entrar")

    const createAlert = () => Alert.alert(
        "Oops!",
        "Verifique se o campo matrícula e senha estão preenchidos."
    );

    function Entrar() {
        if (matricula == null) {
            createAlert();
        }else{ if (senha == null){
          createAlert();
      }else{
        navigation.navigate("Home");
    }
        }
    }
    return (
            <View style={styles.form}>
            <Text style={styles.Login}>Login</Text>
            <View style={styles.Tela}>
                <Text style={styles.title}>Digite seu CPF</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setMatricula}
                    value={matricula}
                    placeholder="CPF"
                    keyboardType="numeric"
                />
                <Text style={styles.title}>Digite sua Senha</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setSenha}
                    value={senha}
                    placeholder="Senha"
                />
                <TouchableOpacity style={styles.buttonAcessar}onPress={() => navigation.navigate("RecuperarConta")}>
                        <Text style={styles.textButtonAcessar}>Esqueci minha senha</Text>
                </TouchableOpacity>
                <View style={styles.botaoArea}>
                <TouchableOpacity style={styles.botao}  onPress={() => navigation.navigate("Cadastro")}>
                        <Text style={styles.botaoS}>Cadastrar</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={[styles.botao,styles.botaoSalvar]}
                    onPress={() => Entrar()}
                >
                    <Text style={styles.textButtonClean}>{textButton}</Text>
                    </TouchableOpacity>
                </View>
                </View>
            </View>
    )
}
const styles = StyleSheet.create({
    buttonAcessar:{
        marginLeft:180
    },
    Tela:{
        marginTop:50
    },
    title:{
      fontSize:17
    },
    Login: {
      fontSize:30,
      marginTop:180,
    },
  form:{
    marginTop:-80,
      flex:1,
      backgroundColor:'#1E90FF',
      padding:10,
  },
  input:{
      borderRadius:10,
      backgroundColor:"#DCDCDC",
      height:60,
      margin:12,
      paddingLeft:10,
  },
  textButtonClean:{
      fontSize:22,
      color:"#FFFFFF"
  },
  botao:{
    backgroundColor:"#FFFFFF",
    borderRadius:8,
    marginLeft:25,
    flex:1,
    alignItems:'center',
    marginTop:10,
    padding:6,
},
botaoS:{
    fontSize:22,
    color:"#253BFF",
    borderColor:'#392DE9',
},
botaoSalvar:{
  backgroundColor:"#392DE9",
  borderRadius:8,
},
botaoArea:{
  flexDirection:"row",
  width:'90%',
  marginTop:130,
  alignItems:'center',
  justifyContent:"space-between"
},
});