import { useState,useContext } from "react";
import { View, TextInput, Text, TouchableOpacity, Alert } from "react-native";
import styles from "./style";
import { useNavigation } from "@react-navigation/native";
import logo from "../imagens/logo.png"
import { AuthContext } from "../../context/auth"

export default function Form() {
    const navigation = useNavigation();
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [textButton] = useState("Entrar");
    const { logIn } = useContext(AuthContext);

    const createAlert = () => Alert.alert(
        "Oops!",
        "Verifique se o campo email e senha estão preenchidos."
    );
      
    function Entrar() {
        if (email == "" || senha == "") {
            createAlert();
        } else {
            logIn(email, senha);
            //console.log(email , senha);//usei para verificar as informacoes recebidas do app no terminal
        }
    }
    
    
    return (
        <View style={styles.form}>
            <Text style={styles.Login}>Faça Login</Text>
            <View style={styles.Tela}>
                <Text style={styles.title}>Digite seu Email</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setEmail}
                    value={email}
                    placeholder="Email"
                />
                <Text style={styles.title}>Digite sua Senha</Text>
                <TextInput
                    style={styles.input}
                    onChangeText={setSenha}
                    value={senha}
                    placeholder="Senha"
                    secureTextEntry={true}
                />
                <TouchableOpacity style={styles.buttonAcessar} onPress={() => navigation.navigate("RecuperarConta")}>
                    <Text style={styles.textButtonAcessar}>Esqueci minha senha</Text>
                </TouchableOpacity>
                <View style={styles.botaoArea}>
                    <TouchableOpacity style={styles.botao} onPress={() => navigation.navigate("Cadastro")}>
                        <Text style={styles.botaoS}>Cadastrar</Text>
                    </TouchableOpacity>
                    <TouchableOpacity style={[styles.botao, styles.botaoSalvar]}
                        onPress={() => Entrar()}
                    >
                        <Text style={styles.textButtonClean}>{textButton}</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </View>
    )
}
